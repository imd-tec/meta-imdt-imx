#!/bin/sh
#
# Copyright (c) 2021 IMD Technologies
#

rm -f /opt/imdt/camera-demo/www/stream1/*.ts
rm -f /opt/imdt/camera-demo/www/stream1/*.m3u8

gst-launch-1.0 v4l2src device=/dev/video3 ! queue ! video/x-raw,width=1920,height=1080 ! vpuenc_h264 ! mpegtsmux ! \
    hlssink target-duration=1 max-files=10 playlist-location=/opt/imdt/camera-demo/www/stream1/playlist.m3u8 location=/opt/imdt/camera-demo/www/stream1/segment%05d.ts
