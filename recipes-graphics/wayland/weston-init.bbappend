do_install:append() {
    # weston-init.bbappend under meta-freescale does not populate a backend property,
    # thus Weston will fail to start. Set it to the drm-backend by default.
    sed -i -e "/^\[core\]/a backend=drm-backend.so" ${D}${sysconfdir}/xdg/weston/weston.ini
}
