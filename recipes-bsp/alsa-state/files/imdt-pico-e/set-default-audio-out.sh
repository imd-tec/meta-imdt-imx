#!/bin/bash

# Define the directory containing the configuration files
CONFIG_DIR="/etc/"

# Check for the number of arguments
if [ "$#" -ne 1 ]; then
    echo "Usage: $0 <1 for speakers/headphones, 2 for HDMI audio>"
    exit 1
fi

# Check the argument and set the source file accordingly
if [ "$1" -eq 1 ]; then
    SOURCE_FILE="$CONFIG_DIR/asound-card-default.conf"
elif [ "$1" -eq 2 ]; then
    SOURCE_FILE="$CONFIG_DIR/asound-hdmi-default.conf"
else
    echo "Invalid argument. Please use 1 for speakers/headphones or 2 for HDMI audio"
    exit 1
fi

# Check if asound.conf exists and create a backup if it does
if [ -e "$CONFIG_DIR/asound.conf" ]; then
    mv "$CONFIG_DIR/asound.conf" "$CONFIG_DIR/asound.conf.bak"
fi

# Copy the selected source file to asound.conf
cp "$SOURCE_FILE" "$CONFIG_DIR/asound.conf"
echo "asound.conf replaced with $SOURCE_FILE."

# Restart ALSA for the changes to take effect
systemctl restart alsa-restore.service
systemctl restart alsa-state.service
