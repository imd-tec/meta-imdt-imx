#
# Copyright (c) 2022 IMD Technologies
#

SUMMARY = "Linux kernel provided and supported by IMD Technologies"

SRC_URI = "git://git@github.com/imd-tec/linux-imdt.git;protocol=ssh;branch=imdt-5.10.72"
SRCREV = "e2fe60d165aa37f14b3a199e325a51c72fa56824"

KERNEL_DEFCONFIG = "imx_v8_defconfig"
KERNEL_DEFCONFIG_imx8mp-imdt-pico-v2 = "imdt_pico_v2_defconfig"
KERNEL_DEFCONFIG_imx8mp-imdt-uevk = "imdt_uevk_defconfig"

do_copy_defconfig() {
    install -d ${B}
    mkdir -p ${B}
    cp ${S}/arch/arm64/configs/${KERNEL_DEFCONFIG} ${B}/.config
    cp ${S}/arch/arm64/configs/${KERNEL_DEFCONFIG} ${B}/../defconfig
}
