#!/bin/sh
#
# Copyright (c) 2021 IMD Technologies
#

mkdir -p /opt/imdt/camera-demo/www/snapshots

gst-launch-1.0 v4l2src device=/dev/video3 num-buffers=1 ! video/x-raw,width=4096,height=3120 ! pngenc ! filesink location=/opt/imdt/camera-demo/www/snapshots/camera1-`date +%Y-%m-%d-%H-%M-%S`.png
