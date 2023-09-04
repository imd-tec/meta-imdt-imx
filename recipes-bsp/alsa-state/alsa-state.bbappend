FILESEXTRAPATHS_prepend_imdt-pico-e := "${THISDIR}/files:"

SRC_URI_append_imdt-pico-e = " \
    file://mozart.wav \
"

do_install_append_imdt-pico-e () {
    install -d ${D}/opt/imdt/audio/
    install -m 0644 ${WORKDIR}/mozart.wav ${D}/opt/imdt/audio/
}

FILES_${PN}_append_imdt-pico-e = " \
    /opt/imdt/audio/ \
"
