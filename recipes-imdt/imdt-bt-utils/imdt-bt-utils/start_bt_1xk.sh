#!/bin/sh
#
# Copyright (c) 2022 IMD Technologies
#

hciattach /dev/ttymxc0 any 115200 flow
hciconfig hci0 up
hcitool -i hci0 cmd 0x3f 0x0009 0xc0 0xc6 0x2d 0x00
killall hciattach
hciattach /dev/ttymxc0 any -s 3000000 3000000 flow
hciconfig hci0 up
hciconfig hci0 piscan
hciconfig hci0 noencrypt
hciconfig -a
