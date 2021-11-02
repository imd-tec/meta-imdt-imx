#!/bin/sh
#
# Copyright (c) 2021 IMD Technologies
#

output_path=/opt/imdt/camera-demo/www/snapshots

mkdir -p $output_path/thumbnails

filename=camera1-`date +%Y-%m-%d-%H-%M-%S`.png

gst-launch-1.0 -q v4l2src device=/dev/video3 num-buffers=3 ! video/x-raw,width=4096,height=3120 ! pngenc compression-level=1 ! multifilesink location=$output_path/$filename

convert.im7 -thumbnail 512 $output_path/$filename $output_path/thumbnails/$filename

echo -n $filename
