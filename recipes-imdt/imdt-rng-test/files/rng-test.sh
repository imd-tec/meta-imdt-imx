#!/bin/bash
random_data=$(dd if=/dev/hwrng bs=32 count=1 | hexdump -v -e '32/1 "%02X "')

if [ -z "$random_data" ]; then
    echo "Failed to read random data"
    exit 1
fi

echo "Random Data: $random_data"
