LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

IMAGE_DEPENDS = "${IMDT_BASE_IMAGE}"

SRC_URI = " \
    file://update.sh \
"

IMDT_IMAGE_NAME = "${IMDT_BASE_IMAGE}-${MACHINE}.rootfs" 

SWUPDATE_IMAGES = " \
    Image \
    tee.bin \
    ${IMDT_IMAGE_NAME}.tar.zst \
"

python __anonymous() {
    kernel_devicetree = d.getVar('KERNEL_DEVICETREE').split()
    dtb_files = [os.path.basename(f) for f in kernel_devicetree]

    swupdate_images = d.getVar('SWUPDATE_IMAGES') or ""
    swupdate_images += " " + " ".join(dtb_files)

    d.setVar('SWUPDATE_IMAGES', swupdate_images)
}

python do_generate_sw_description() {
    import shutil
    import bb.utils
    import os

    # Get WORKDIR dynamically from BitBake
    workdir = d.getVar('WORKDIR', True)

    # Find sw-description.in using bb.utils.which
    sw_desc_in_path = bb.utils.which(d.getVar('FILESPATH', True), "sw-description.in")

    if not sw_desc_in_path:
        bb.fatal("sw-description.in not found in FILESPATH (excluding __default)")

    # Log the found sw-description.in path
    bb.note("Found sw-description.in at: %s" % sw_desc_in_path)

    # Copy the sw-description.in to WORKDIR so we can process it
    sw_desc_in_dest = os.path.join(workdir, "sw-description.in")
    shutil.copyfile(sw_desc_in_path, sw_desc_in_dest)
    bb.note("Copied sw-description.in from %s to %s" % (sw_desc_in_path, sw_desc_in_dest))

    # Now generate the sw-description file
    sw_desc_output_path = os.path.join(workdir, "sw-description")

    # Read the input template
    with open(sw_desc_in_dest, 'r') as infile:
        content = infile.read()

    # Replace fixed placeholders
    content = content.replace('@TARFILE@', d.getVar('IMDT_IMAGE_NAME') + ".tar.zst")
    content = content.replace('@MACHINE@', d.getVar('MACHINE'))

    # Dynamically create 'files' entries
    swupdate_images = d.getVar('SWUPDATE_IMAGES').split()
    file_entries = []
    for fname in swupdate_images:
        if fname.endswith(('.dtb', '.dtbo', 'Image', 'tee.bin')):
            entry = f'''\
            {{
                filename = "{fname}";
                device = "/dev/update-boot";
                path = "{fname}";
                filesystem = "vfat";
            }}'''
            file_entries.append(entry)

    # Join all entries into one 'files' section
    files_block = "files:\n        (\n" + ",\n".join(file_entries) + "\n        );"

    # Inject the generated files block
    content = content.replace('@FILES_BLOCK@', files_block)

    # Write the final sw-description
    with open(sw_desc_output_path, 'w') as outfile:
        outfile.write(content)

    # Log the successful generation of sw-description
    bb.note("Generated sw-description with dynamic files block at: %s" % sw_desc_output_path)
}

addtask do_generate_sw_description after do_fetch before do_swuimage