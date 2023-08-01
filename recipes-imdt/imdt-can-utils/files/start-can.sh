#!/bin/bash
#: Title        : start-can.sh
#: Author       : Lewis Purvis
#: Description  : brings the CAN interface up at 250000 baud

ip link set can0 type can bitrate 250000
ip link set up can0
