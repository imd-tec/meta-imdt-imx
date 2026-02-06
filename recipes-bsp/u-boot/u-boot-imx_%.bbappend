#
# Copyright (c) 2025 IMD Technologies
#

SUMMARY = "U-Boot bootloader provided and supported by IMD Technologies"

SRC_URI = "git://github.com/imd-tec/uboot-imdt.git;protocol=https;branch=imdt-v2024.04"
SRCREV = "20862d4fe4e5221ed5a52af86b4712ddd190baf8"

DEPENDS += "u-boot-tools-native"

UBOOT_INITIAL_ENV = "u-boot-initial-env"
ENV_FILE_PATH="${B}/${UBOOT_INITIAL_ENV}"
ENV_FILE_PATH_BIN="${B}/${UBOOT_INITIAL_ENV}.bin"

do_compile:append() {
    # Check if the canonical file exists
    if [ ! -f "$ENV_FILE_PATH" ]; then
        # Search config-specific env files
        found=""
        for config in ${UBOOT_MACHINE}; do
            for type in ${UBOOT_CONFIG}; do
                candidate="${B}/${config}/${UBOOT_INITIAL_ENV}-${type}"
                if [ -f "$candidate" ]; then
                    if [ "$type" = "sd" ]; then
                        found="$candidate"
                        break 2  # prefer "sd" immediately
                    elif [ -z "$found" ]; then
                        found="$candidate"
                    fi
                fi
            done
        done

        if [ -z "$found" ]; then
            echo "ERROR: No u-boot environment source found!" >&2
            return 1
        fi

        ENV_FILE_PATH="$found"
    fi

    # Generate the binary using mkenvimage
    echo "Generating U-Boot environment image from ${ENV_FILE_PATH}..."
    mkenvimage -s 0x20000 -o "${ENV_FILE_PATH_BIN}" "$ENV_FILE_PATH"
}

do_install:append(){
    if [ -n "${UBOOT_INITIAL_ENV}" ]; then
        install -D -m 644 ${ENV_FILE_PATH_BIN} ${D}/uboot-env/${UBOOT_INITIAL_ENV}.bin
    fi
}

FILES:${PN} += "/uboot-env"

do_deploy:append(){
    # Deploy the uboot-initial-env
    if [ -n "${UBOOT_INITIAL_ENV}" ]; then
        mkdir -p ${DEPLOYDIR}/uboot-env
        install -D -m 644 ${ENV_FILE_PATH_BIN} ${DEPLOYDIR}/uboot-env/${UBOOT_INITIAL_ENV}.bin
    fi
}

do_compile[depends] += "u-boot-tools-native:do_populate_sysroot"