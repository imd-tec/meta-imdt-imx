DESCRIPTION = "IMDT SWUpdate Doctor - A oneshot service that will mark an update as successful after booting into a new SWUpdate image"
LICENSE = "CLOSED"
inherit systemd
FILES:${PN} = "/opt/imdt/swupdate-doctor/* \
                 ${systemd_system_unitdir}/imdt-swupdate-doctor.service"

SYSTEMD_SERVICE:${PN} = "imdt-swupdate-doctor.service"
# SystemD service will be auto-enabled
RDEPENDS:${PN} = "swupdate u-boot-fw-utils"
SRC_URI = "file://imdt-swupdate-doctor.service \
           file://reset-bootcount.sh "
do_install() {
    # Install the systemd service file
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/imdt-swupdate-doctor.service ${D}${systemd_system_unitdir}/imdt-swupdate-doctor.service
    # Install the reset-bootcount script
    install -d ${D}/opt/imdt/swupdate-doctor
    install -m 0755 ${WORKDIR}/reset-bootcount.sh ${D}/opt/imdt/swupdate-doctor/reset-bootcount.sh
}
