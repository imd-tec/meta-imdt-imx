#
# Copyright (c) 2022 IMD Technologies
#

SUMMARY = "Linux kernel provided and supported by IMD Technologies"

SRC_URI = "git://github.com/imd-tec/linux-imdt.git;protocol=https;branch=imdt-6.6.y"
SRCREV = "186602c566f766fb6139836dc5d057190d3160e4"


IMX_KERNEL_CONFIG_AARCH64:imdt-pico = "imdt_pico_defconfig"

