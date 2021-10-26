FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://25-wlan.network \
"

FILES_${PN} += " \
    ${sysconfdir}/systemd/network/25-wlan.network \
"

do_install_append() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/25-wlan.network ${D}${sysconfdir}/systemd/network
}