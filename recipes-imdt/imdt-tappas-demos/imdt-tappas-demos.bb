#
# Copyright (c) 2023 IMD Technologies
#

DESCRIPTION = "Scrips to run TAPPAS demos on a Pico"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PV = "1.0.0"

SRC_URI = " \
    file://face_detection_and_landmarks.sh \
    file://live_face_detection_and_landmarks.sh \
    file://depth_estimation.sh \
    file://live_depth_estimation.sh \
    file://live_detection.sh \
    file://license_plate_recognition.sh \
    file://multi_stream_detection.sh \
    file://live_pose_estimation.sh \
    file://semantic_segmentation.sh \
    file://_loop.sh \
    file://_slideshow.sh \
"
do_install() {
    install -d ${D}/opt/imdt/tappas
    install -m 0744 ${WORKDIR}/face_detection_and_landmarks.sh ${D}/opt/imdt/tappas
    install -m 0744 ${WORKDIR}/live_face_detection_and_landmarks.sh ${D}/opt/imdt/tappas
    install -m 0744 ${WORKDIR}/depth_estimation.sh ${D}/opt/imdt/tappas
    install -m 0744 ${WORKDIR}/live_depth_estimation.sh ${D}/opt/imdt/tappas
    install -m 0744 ${WORKDIR}/live_detection.sh ${D}/opt/imdt/tappas
    install -m 0744 ${WORKDIR}/license_plate_recognition.sh ${D}/opt/imdt/tappas
    install -m 0744 ${WORKDIR}/multi_stream_detection.sh ${D}/opt/imdt/tappas
    install -m 0744 ${WORKDIR}/live_pose_estimation.sh ${D}/opt/imdt/tappas
    install -m 0744 ${WORKDIR}/semantic_segmentation.sh ${D}/opt/imdt/tappas
    install -m 0744 ${WORKDIR}/_loop.sh ${D}/opt/imdt/tappas
    install -m 0744 ${WORKDIR}/_slideshow.sh ${D}/opt/imdt/tappas
}

FILES_${PN} += " \
    /opt/imdt/tappas/ \
"

RDEPENDS_${PN} += "bash"
