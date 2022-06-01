#!/bin/sh
#
# Copyright (c) 2022 IMD Technologies
#

hciattach /dev/ttymxc0 bcm43xx
hciconfig hci0 up
