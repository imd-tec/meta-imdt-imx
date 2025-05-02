# this release has been removed from the remote repo, but exists as an archive. 

SRC_URI_prepend = "https://github.com/c-ares/c-ares/releases/download/cares-1_16_1/c-ares-1.16.1.tar.gz"
SRC_URI_remove = "git://github.com/c-ares/c-ares.git"
SRC_URI[sha256sum] = "d08312d0ecc3bd48eee0a4cc0d2137c9f194e0a28de2028928c0f6cae85f86ce"

# override with correct version number
PV = "1.16.1"

# set back to default value when PV isn't set
S = "${WORKDIR}/c-ares-${PV}"

# INVALID is the default value when SRCREV isn't explicitly set. 
SRCREV = "INVALID"

#remove the setting of this variable
unset UPSTREAM_CHECK_GITTAGREGEX
