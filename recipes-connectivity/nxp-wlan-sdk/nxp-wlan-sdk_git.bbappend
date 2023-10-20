require nxp-wlan-sdk_git_6_1_36.inc

do_install() {
    install -d ${D}${datadir}/nxp_wireless
    install -m 0755 script/load ${D}${datadir}/nxp_wireless
    install -m 0755 script/unload ${D}${datadir}/nxp_wireless
    install -m 0644 README ${D}${datadir}/nxp_wireless
}
