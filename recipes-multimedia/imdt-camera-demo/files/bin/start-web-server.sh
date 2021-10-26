#!/bin/sh

rf -f /opt/imdt/camera-demo/www/snapshots/*.jpg

python3 -m http.server 80 --directory /opt/imdt/camera-demo/www/
