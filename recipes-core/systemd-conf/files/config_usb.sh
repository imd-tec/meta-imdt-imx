# Copyright (C) 2025 IMD Technologies
set -e

G=/sys/kernel/config/usb_gadget/g1

mkdir -p $G
cd $G

echo 0x1d6b > idVendor       # Linux Foundation
echo 0x0104 > idProduct      # Multifunction Composite Gadget

# Set USB version to 3.0 (SuperSpeed)
echo 0x0300 > bcdUSB

# Device release number
echo 0x0100 > bcdDevice
# Set the device class to "Communications and CDC Control"
# This is a composite device with two functions: ACM (serial) and RNDIS (network)
echo 0xEF > bDeviceClass
echo 0x02 > bDeviceSubClass
echo 0x01 > bDeviceProtocol

mkdir -p strings/0x409
## Add strings for the device
echo "01" > strings/0x409/serialnumber
echo "IMD Technology"        > strings/0x409/manufacturer
echo "Pico"   > strings/0x409/product

mkdir -p configs/c.1
echo 250 > configs/c.1/MaxPower

mkdir -p functions/rndis.usb0  # network

ln -s functions/rndis.usb0 configs/c.1/

# # OS descriptors f0r windows - Might not be nbecessary for RNDIS
# echo 1       > os_desc/use
# echo 0xcd    > os_desc/b_vendor_code
# echo MSFT100 > os_desc/qw_sign

# echo RNDIS   > functions/rndis.usb0/os_desc/interface.rndis/compatible_id
# echo 5162001 > functions/rndis.usb0/os_desc/interface.rndis/sub_compatible_id

echo "EF" > functions/rndis.usb0/class
echo "04" > functions/rndis.usb0/subclass
echo "01" > functions/rndis.usb0/protocol

ln -s configs/c.1 os_desc

UDC=$(ls /sys/class/udc | head -n 1)
echo $UDC > UDC
