#!/bin/sh
#
# Copyright (c) 2021 IMD Technologies
#

rf -f /opt/imdt/camera-demo/www/snapshots/*.jpg
mkdir -p /opt/imdt/camera-demo/www/snapshots

python3 -m http.server 80 --directory /opt/imdt/camera-demo/www/
