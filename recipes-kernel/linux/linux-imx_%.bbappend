#
# Copyright (c) 2022 IMD Technologies
#

SUMMARY = "Linux kernel provided and supported by IMD Technologies"

SRC_URI = "git://github.com/imd-tec/linux-imdt.git;protocol=https;branch=imdt-6.6.y"
SRCREV = "c4ba910a9ef5f8bf413e6fb85c2c104cc4f35426"


IMX_KERNEL_CONFIG_AARCH64:imx8mp-imdt-pico-em = "imdt_pico_em_defconfig"
IMX_KERNEL_CONFIG_AARCH64:imx8mp-imdt-pico-e = "imdt_pico_e_defconfig"
IMX_KERNEL_CONFIG_AARCH64:imx8mp-imdt-pico-v2 = "imdt_pico_v2_defconfig"
IMX_KERNEL_CONFIG_AARCH64:imx8mp-imdt-pico-v3 = "imdt_pico_v3_defconfig"
IMX_KERNEL_CONFIG_AARCH64:imx8mp-imdt-pico-v3-0004 = "imdt_pico_v3_0004_defconfig"
IMX_KERNEL_CONFIG_AARCH64:imx8mp-imdt-pico-v3-0005 = "imdt_pico_v3_0005_defconfig"
IMX_KERNEL_CONFIG_AARCH64:imx8mp-imdt-uevk = "imdt_uevk_defconfig"

