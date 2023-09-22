FILESEXTRAPATHS_prepend_imdt-pico-e := "${THISDIR}/files:"

SRC_URI_append_imdt-pico-e = " \
    file://mozart.wav \
    file://asound-card-default.conf \
    file://asound-hdmi-default.conf \
    file://set-default-audio-out.sh \
"
RDEPENDS_${PN} += "bash"

do_install_append_imdt-pico-e () {

    # install audio files and scripts
    install -d ${D}/opt/imdt/audio/
    install -m 0644 ${WORKDIR}/mozart.wav ${D}/opt/imdt/audio/
    install -m 0744 ${WORKDIR}/set-default-audio-out.sh ${D}/opt/imdt/audio/

    # install asound.conf default files
    install -m 0644 ${WORKDIR}/asound-card-default.conf ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/asound-hdmi-default.conf ${D}${sysconfdir}

    # replace asound.conf with asound-card-default.conf
    rm -f ${D}${sysconfdir}/asound.conf
    install -m 0644 ${WORKDIR}/asound-card-default.conf ${D}${sysconfdir}/asound.conf
}

FILES_${PN}_append_imdt-pico-e = " \
    /opt/imdt/audio/ \
    ${sysconfdir}/asound-card-default.conf \
    ${sysconfdir}/asound-hdmi-default.conf \
"
