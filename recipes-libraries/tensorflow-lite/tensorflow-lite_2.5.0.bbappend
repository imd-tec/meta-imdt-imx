FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-Add-Int8-type-support-for-the-Quantize-and-Dequantiz.patch \
            file://0002-Remove-debug-statements-from-VX-delegate.patch \
            "
