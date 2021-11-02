#!/bin/sh
#
# Copyright (c) 2021 IMD Technologies
#

mkdir -p /opt/imdt/camera-demo/www/snapshots/thumbnails
mkdir -p /opt/imdt/camera-demo/www/stream1

cd /opt/imdt/camera-demo/www

python3 server.py
