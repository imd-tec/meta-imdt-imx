#!/bin/sh

gst-launch-1.0 v4l2src device=/dev/video4 num-buffers=1 ! video/x-raw,width=2048,height=1560 ! jpegenc ! filesink location=/opt/imdt/camera-demo/www/snapshots/camera2-`date +%Y-%m-%d-%H-%M-%S`.jpg
