#
# Copyright (c) 2022 IMD Technologies
#

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += " \
    file://imdt-libubootenv-config.service \
    file://fw_env.config \
    file://mount-env.sh \
"

inherit systemd

do_install:append () {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/imdt-libubootenv-config.service ${D}${systemd_system_unitdir}

    install -D -m 0744 ${WORKDIR}/mount-env.sh ${D}/opt/imdt/libubootenv/mount-env.sh
    install -D -m 0744 ${WORKDIR}/fw_env.config ${D}/etc/fw_env.config
}

RDEPENDS:${PN}:append = " bash"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "imdt-libubootenv-config.service"

FILES:${PN} += " \
    /opt/ \
    /etc/fw_env.config \
"
