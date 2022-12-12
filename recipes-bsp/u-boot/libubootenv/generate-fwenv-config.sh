#!/bin/bash

# Default to the micro SD card
CURRENT_ROOT=/dev/mmcblk1

# Search the kernel command line for the rootfs location
for i in `cat /proc/cmdline`; do
        if [ ${i:0:5} = "root=" ]; then
                CURRENT_ROOT="${i:5:-2}"
        fi
done

# Update the fw_env.config file
echo "${CURRENT_ROOT} 0x400000 0x4000" > /etc/fw_env.config
