
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

DEPENDS += "virtual/libg2d"

GN_ARGS += '\
    use_v4lplugin=false \
    use_linux_v4l2_only=true \
    use_v4l2_codec=true \
    proprietary_codecs=true \
    ffmpeg_branding="Chrome" \
'

SRC_URI:append = " \
    file://chromium-v4l.patch \
    file://chromium-launch.sh \
"

do_install:append() {
    install -d ${D}/home/root/
    install -m 0744 ${WORKDIR}/chromium-launch.sh ${D}/home/root/
}

FILES:${PN} += " \
    /home/root/ \
"