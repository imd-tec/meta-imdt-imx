FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://wifi_mod_para.patch"

S = "${WORKDIR}/git"
