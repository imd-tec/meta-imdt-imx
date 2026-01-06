require conf/distro/poky.conf

DISTRO_NAME = "IMDT Pico BSP"

REMOVE_VULKAN_FEATURE_mx8 = ""
POKY_DEFAULT_DISTRO_FEATURES:remove      = "wayland"
POKY_DEFAULT_DISTRO_FEATURES:append_mx8  = " jailhouse"

DISTRO_FEATURES:append_mx8 = " virtualization"

INHERIT:remove = "uninative"

PACKAGECONFIG:append:pn-gstreamer1.0-plugins-ugly = " x264"
