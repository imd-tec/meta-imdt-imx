#
# Copyright (c) 2022 IMD Technologies
#

SUMMARY = "Linux kernel provided and supported by IMD Technologies"

SRC_URI = "git://github.com/imd-tec/linux-imdt.git;protocol=https;branch=imdt-6.6.y"
SRCREV = "7dcc3ce050510897876906e18da1250e58c90ac7"


IMX_KERNEL_CONFIG_AARCH64:imdt-pico = "imdt_pico_defconfig"

