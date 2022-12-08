#
# Copyright (c) 2022 IMD Technologies
#

SUMMARY = "Linux kernel provided and supported by IMD Technologies"

SRC_URI = "git://github.com/imd-tec/linux-imdt.git;protocol=https;branch=imdt-5.10.72"
SRCREV = "2488a4494acf50656d6839e90a7b23f3e8fb3006"

KERNEL_DEFCONFIG = "imx_v8_defconfig"
KERNEL_DEFCONFIG_imx8mp-imdt-pico-v2 = "imdt_pico_v2_defconfig"
KERNEL_DEFCONFIG_imx8mp-imdt-pico-v3 = "imdt_pico_v3_defconfig"
KERNEL_DEFCONFIG_imx8mp-imdt-pico-v3-0004 = "imdt_pico_v3_0004_defconfig"
KERNEL_DEFCONFIG_imx8mp-imdt-uevk = "imdt_uevk_defconfig"

do_copy_defconfig() {
    install -d ${B}
    mkdir -p ${B}
    cp ${S}/arch/arm64/configs/${KERNEL_DEFCONFIG} ${B}/.config
    cp ${S}/arch/arm64/configs/${KERNEL_DEFCONFIG} ${B}/../defconfig
}
