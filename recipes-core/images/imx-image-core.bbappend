# Copyright (c) 2021 IMD Technologies

IMAGE_INSTALL_append_imx8mp-imdt-picoevk = " \
    wpa-supplicant wireless-tools hostapd dhcpcd linux-firmware wireless-regdb-static \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
    yavta \
    v4l-utils \
    socat picocom \
"

IMAGE_INSTALL_append_imx8mp-imdt-uevk = " \
    linux-firmware \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
    yavta \
    v4l-utils \
"
