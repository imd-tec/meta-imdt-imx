LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

IMAGE_DEPENDS = "${IMDT_BASE_IMAGE}"

SRC_URI = " \
    file://update.sh \
"

IMDT_IMAGE_NAME = "${IMDT_BASE_IMAGE}-${MACHINE}" 

SWUPDATE_IMAGES = " \
    Image \
    ${MACHINE}.dtb \
    tee.bin \
    ${IMDT_IMAGE_NAME}.tar.gz \
"

addtask do_generate_sw_description after do_fetch before do_swuimage