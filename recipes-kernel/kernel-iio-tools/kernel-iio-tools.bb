# Copyright 2020 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Kernel test tools for Linux"
DESCRIPTION = "Kernel test tools for Linux"
LICENSE = "GPLv2"

inherit linux-kernel-base kernel-arch
inherit kernelsrc

S = "${WORKDIR}/${BP}"

KERNEL_IIOTEST_SRC ?= " \
             include \
             tools/arch \
             tools/build \
             tools/include \
             tools/lib \
             tools/Makefile \
             tools/iio \
             tools/scripts \
"
do_configure[depends] += "virtual/kernel:do_shared_workdir"

do_configure[prefuncs] += "copy_iio_source_from_kernel"
python copy_iio_source_from_kernel() {
    sources = (d.getVar("KERNEL_IIOTEST_SRC") or "").split()
    src_dir = d.getVar("STAGING_KERNEL_DIR")
    dest_dir = d.getVar("S")
    bb.utils.mkdirhier(dest_dir)
    for s in sources:
        src = oe.path.join(src_dir, s)
        dest = oe.path.join(dest_dir, s)
        if not os.path.exists(src):
            bb.fatal("Path does not exist: %s. Maybe PERF_SRC does not match the kernel version." % src)
        if os.path.isdir(src):
            oe.path.copyhardlinktree(src, dest)
        else:
            bb.utils.copyfile(src, dest)
}

EXTRA_OEMAKE = '\
    CROSS_COMPILE=${TARGET_PREFIX} \
    ARCH=${ARCH} \
    CC="${CC}" \
    AR="${AR}" \
    LD="${LD}" \
    DESTDIR="${D}" \
'

do_compile() {
    unset CFLAGS
    oe_runmake -C ${S}/tools/iio
}

do_install() {
    unset CFLAGS
    oe_runmake -C ${S}/tools/iio install
}

ALLOW_EMPTY_${PN} = "1"

#PACKAGES =+ "${PN}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
