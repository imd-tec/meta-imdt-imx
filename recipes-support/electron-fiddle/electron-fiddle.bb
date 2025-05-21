SUMMARY = "Electron Fiddle"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://usr/lib/electron-fiddle/LICENSE;md5=4d42118d35941e0f664dddbd83f633c5 \
                    file://usr/lib/electron-fiddle/LICENSES.chromium.html;md5=b96669e5999e1b931d7529d58ffeacfe"

SRC_URI = "https://github.com/electron/fiddle/releases/download/v0.36.4/electron-fiddle-0.36.4-1.arm64.rpm;downloadfilename=electron-fiddle-0.36.4-1.arm64.rpm;subdir=rpm"

SRC_URI[sha256sum] = "6023a8e7876ec8fe06be98a7fd5e8106aff085eff6ee5541b86f0a243c9d340d"

S = "${WORKDIR}/rpm"

inherit mime-xdg

# Copy the contents of the RPM to the root filesystem
do_install:append() {
    cp -R ${S}/* ${D}
}

FILES:${PN} = "/usr/bin/electron-fiddle \
               /usr/lib/electron-fiddle \
               /usr/lib/.build-id \
               /usr/share/applications/electron-fiddle.desktop \
               /usr/share/icons/hicolor \
"

RDEPENDS:${PN} += " \
    gtk+3 \
    nss \
    nspr \
    libxcomposite \
    libxdamage \
    libxext \
    libxfixes \
    libxrandr \
    at-spi2-atk \
    at-spi2-core \
    alsa-lib \
    libdrm \
    atk \
    cairo \
    pango \
    libgbm-imx \
    expat \
    cups-lib \
"
