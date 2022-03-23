SUMMARY = "Linux kernel provided and supported by IMD Technologies"

SRC_URI = "git://git@github.com/imd-tec/linux-imdt.git;protocol=ssh;branch=imdt-5.10.52"
SRCREV = "1ef008b729f9d7f3dc6aefabe224971d959ffe45"

KERNEL_DEFCONFIG = "imx_v8_defconfig"
KERNEL_DEFCONFIG_imx8mp-imdt-picoevk = "imdt_picoevk_defconfig"
KERNEL_DEFCONFIG_imx8mp-imdt-uevk = "imdt_uevk_defconfig"
KERNEL_DEFCONFIG_imx8mp-imdt-uevk-2g = "imdt_uevk_2g_defconfig"

do_copy_defconfig() {
    install -d ${B}
    mkdir -p ${B}
    cp ${S}/arch/arm64/configs/${KERNEL_DEFCONFIG} ${B}/.config
    cp ${S}/arch/arm64/configs/${KERNEL_DEFCONFIG} ${B}/../defconfig
}