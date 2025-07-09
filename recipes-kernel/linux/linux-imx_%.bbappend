#
# Copyright (c) 2022 IMD Technologies
#

SUMMARY = "Linux kernel provided and supported by IMD Technologies"

SRC_URI = "git://github.com/imd-tec/linux-imdt.git;protocol=https;branch=imdt-6.6.y"
SRCREV = "c865eb063cb1857062767ec47d9da42ab95dfe32"


IMX_KERNEL_CONFIG_AARCH64:imdt-pico = "imdt_pico_defconfig"

