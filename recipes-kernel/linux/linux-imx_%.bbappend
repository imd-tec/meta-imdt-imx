#
# Copyright (c) 2022 IMD Technologies
#

SUMMARY = "Linux kernel provided and supported by IMD Technologies"

SRC_URI = "git://github.com/imd-tec/linux-imdt.git;protocol=https;branch=imdt-6.6.y"
SRCREV = "00bd79ee7785b7fc8f4e4c23a45e96541880f653"


IMX_KERNEL_CONFIG_AARCH64:imdt-pico = "imdt_pico_defconfig"

