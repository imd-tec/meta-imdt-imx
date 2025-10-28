#!/bin/sh
# This script resets the update available flag and bootcount after a successful OTA update
# Read the update_available flag and bootcount from U-Boot environment
UPGRADE_AVAILABLE=$(fw_printenv upgrade_available)
BOOTCOUNT=$(fw_printenv bootcount)
FAILEDUPDATE=$(fw_printenv failed_update)
echo "Current upgrade_available flag: $UPGRADE_AVAILABLE"
echo "Current bootcount: $BOOTCOUNT"
echo "Failed update flag: $FAILEDUPDATE"
if [ "$UPGRADE_AVAILABLE" == "upgrade_available=1" ]; then
    echo "Wiping upgrade_available flag"
    fw_setenv upgrade_available
    echo "Resetting bootcount to 0"
    fw_setenv bootcount 0
    echo "Reset complete."
else
    echo "No pending upgrade detected. No action taken."
fi