# swdescription.bbclass

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
    with open(sw_desc_in_dest, 'r') as infile, open(sw_desc_output_path, 'w') as outfile:
        content = infile.read()
        content = content.replace('@DTB@', d.getVar('MACHINE') + ".dtb")
        content = content.replace('@TARFILE@', d.getVar('IMDT_IMAGE_NAME') + ".tar.gz")
        content = content.replace('@MACHINE@', d.getVar('MACHINE'))
        outfile.write(content)

    # Log the successful generation of sw-description
    bb.note("Generated sw-description at: %s" % sw_desc_output_path)
}

addtask do_generate_sw_description after do_fetch before do_swuimage