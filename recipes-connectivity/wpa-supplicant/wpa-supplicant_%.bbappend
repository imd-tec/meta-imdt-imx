FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_imx8mp-imdt-picoevk = " \
   file://wpa_supplicant-nl80211-wlan0.conf \
"

SYSTEMD_AUTO_ENABLE = "disable"
SYSTEMD_SERVICE_${PN}_append_imx8mp-imdt-picoevk = " wpa_supplicant-nl80211@wlan0.service "

do_install_append_imx8mp-imdt-picoevk () {
   install -d ${D}${sysconfdir}/wpa_supplicant/
   install -D -m 600 ${WORKDIR}/wpa_supplicant-nl80211-wlan0.conf ${D}${sysconfdir}/wpa_supplicant/
}
