PACKAGECONFIG_append_pn-libiio = " libiio-python3"

SRC_URI = "git://github.com/analogdevicesinc/libiio.git;protocol=https;branch="main" \
           file://0001-python-Do-not-verify-whether-libiio-is-installed-whe.patch \
"