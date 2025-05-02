# Copyright (c) 2025 IMD Technologies

DESCRIPTION = "Create a SWUpdate image for the Pico board"

require include/imdt-image-swu.inc

inherit swupdate generate-sw-description

# Dependencies to build before creating the SWUpdate image
IMDT_BASE_IMAGE = "imdt-image-minimal"