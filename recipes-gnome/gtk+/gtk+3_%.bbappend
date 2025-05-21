# meta-freescale/recipes-graphics/gtk+/gtk+3_%.bbappend explictly removes x11 from PACKAGECONFIG as follows:
#PACKAGECONFIG:remove_imxgpu2d = " \
#    ${@bb.utils.contains("DISTRO_FEATURES", "wayland", "x11", "", d)} \
#"
# the remove will always be executed, even if the variable is overidden by this .bbappend being in a higher prioirty layer
# it is for this reason that we are required to modify the make args, as would ave occurred as a result of x11 being enbaled in packageconfig.
# The dependencies are also added manually.

EXTRA_OECONF:append = " --enable-x11-backend"
EXTRA_OECONF:remove = "--disable-x11-backend"

DEPENDS:append = " at-spi2-atk fontconfig libx11 libxext libxcursor libxi libxdamage libxrandr libxrender libxcomposite libxfixes"
