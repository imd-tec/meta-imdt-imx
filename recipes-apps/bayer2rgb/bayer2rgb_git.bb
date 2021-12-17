LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24 \
                    file://vcpkg/LICENSE.txt;md5=8ddf87decfe9df82c148425875d505bc \
                    file://vcpkg/versions/l-/licensepp.json;md5=1408a30623f5cc8a678702a6125a38e3 \
                    file://vcpkg/ports/libunistring/copyright;md5=4b078843215416ed3a4e3941da92cf06 \
                    file://vcpkg/ports/pffft/copyright;md5=d84091c6f72bea04145abecf72b3fc58 \
                    file://vcpkg/ports/cspice/License.txt;md5=50f2f6f6dd9615b543afd74e70684906 \
                    file://vcpkg/ports/libssh2/LICENSE;md5=e835e799ceb0b52c435555f11f7f0628 \
                    file://vcpkg/ports/tinyxml/License.txt;md5=b8a2217abb29bfac938ef20db490cb20 \
                    file://vcpkg/ports/angelscript/LICENSE;md5=52ac54fb1e0c4facfba9d07dc15f2795 \
                    file://vcpkg/ports/treehh/copyright;md5=8555e5ee7645b8df82ff876fe76a7094 \
                    file://vcpkg/ports/bustache/LICENSE;md5=aabce27d48c5b3beac1325fb08e2ca30 \
                    file://vcpkg/ports/irrlicht/LICENSE.txt;md5=41ad09783e043bd07e359ad361b6baf0 \
                    file://vcpkg/ports/mmx/copyright;md5=7d6741f6ee849717fe99e76610c4641e \
                    file://vcpkg/ports/argh/remove_unnamespaced_license_file.patch;md5=e529735daab5cd351ed88a3d4520a22a \
                    file://vcpkg/ports/vcpkg-pkgconfig-get-modules/copyright;md5=8ddf87decfe9df82c148425875d505bc \
                    file://vcpkg/ports/sigslot/LICENSE;md5=e4ded3bf6b28e07585dd85b95dceaf1e \
                    file://vcpkg/ports/pangomm/COPYING;md5=d8045f3b8f929c1cb29a1e3fd737b499 \
                    file://vcpkg/ports/libmesh/copyright;md5=f09ab57d71b632b3d6591ba7b2fc43be \
                    file://vcpkg/ports/tensorflow-common/LICENSE.txt;md5=8ddf87decfe9df82c148425875d505bc \
                    file://vcpkg/ports/monkeys-audio/license;md5=b64cbef4d52dcbb4b383182276bcca1c \
                    file://vcpkg/ports/zlib/LICENSE;md5=811e6bd1c80c45394e3dda849dce07cb \
                    file://vcpkg/ports/discord-game-sdk/copyright;md5=123f38f91483271824bdf8150d5c3192 \
                    file://vcpkg/ports/soil2/LICENSE;md5=c3dc90afc6d16318052fe3ec32ed8ad5 \
                    file://vcpkg/ports/bento4/LICENSE;md5=123c205cdb1cd04650319828f346c3c1 \
                    file://vcpkg/ports/vcpkg-cmake/copyright;md5=8ddf87decfe9df82c148425875d505bc \
                    file://vcpkg/ports/vulkan/LICENSE.txt;md5=7778b1b3662e3d7793e34734bfa4e200 \
                    file://vcpkg/ports/loguru/copyright;md5=3ba2269872d65291a5252e42c29791dd \
                    file://vcpkg/ports/hungarian/LICENSE.txt;md5=e0665d53596e2046e4b662791d67abe7 \
                    file://vcpkg/ports/lua/COPYRIGHT;md5=c14f56d4ab1b03d38ad0c1d17782be46 \
                    file://vcpkg/ports/7zip/License.txt;md5=a3bef28bdcba7c0bdb3b045a1b19d4ca \
                    file://vcpkg/ports/7zip/unRarLicense.txt;md5=9c87ddde469ef94aed153b0951d088de \
                    file://vcpkg/ports/ffnvcodec/LICENSE.txt;md5=f09ab57d71b632b3d6591ba7b2fc43be \
                    file://vcpkg/ports/ffnvcodec/copyright;md5=aa00836f4c18723d43eb7cef20d197d9 \
                    file://vcpkg/ports/pdcurses/LICENSE;md5=b898328b0a0f5079c5ffa361e696483b \
                    file://vcpkg/ports/strtk/copyright;md5=ad8f85b53e7d35c5d8ba9b343b0c376b \
                    file://vcpkg/ports/ampl-asl/copyright;md5=57de316352969c501f60a43cae2aa827 \
                    file://vcpkg/ports/libstemmer/LICENSE;md5=b4c62f1667f94a20481b433f689cf19c \
                    file://vcpkg/ports/gettimeofday/LICENSE;md5=b5a5a0ef2f34a33635ed3e7b023ae7a8 \
                    file://vcpkg/ports/pqp/LICENSE;md5=1d2a93dcca186c75bea16565f8b87c39 \
                    file://vcpkg/ports/exprtk/copyright;md5=fe3444f86cd3275123b0b80921389a79 \
                    file://vcpkg/ports/vcpkg-cmake-config/copyright;md5=8ddf87decfe9df82c148425875d505bc \
                    file://vcpkg/ports/atkmm/COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = "gitsm://github.com/jdthomas/bayer2rgb;protocol=https;branch=main"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "1ce852e3ef0a9ebe308696c02436051508bb098b"

S = "${WORKDIR}/git"

# NOTE: unable to map the following CMake package dependencies: benchmark
DEPENDS = "googletest fmt"

inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""
