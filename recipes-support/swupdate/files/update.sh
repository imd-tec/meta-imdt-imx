#!/bin/sh
set -x

if [ $# -lt 1 ]; then
	exit 0;
fi

function get_current_root_device
{
	for i in `cat /proc/cmdline`; do
		if [ ${i:0:5} = "root=" ]; then
			CURRENT_ROOT="${i:5}"
		fi
	done
}

function get_update_part
{
	CURRENT_PART="${CURRENT_ROOT: -1}"
	if [ $CURRENT_PART = "3" ]; then
        UPDATE_BOOT_PART="4";
		UPDATE_ROOT_PART="5";
	else
        UPDATE_BOOT_PART="2";
		UPDATE_ROOT_PART="3";
	fi
}

function get_update_device
{
    UPDATE_BOOT_DEV=${CURRENT_ROOT%?}${UPDATE_BOOT_PART}
	UPDATE_ROOT_DEV=${CURRENT_ROOT%?}${UPDATE_ROOT_PART}
}

if [ $1 == "preinst" ]; then

	#!/bin/bash
	echo "This script is: $0"
	echo "Called by: $(ps -o comm= $PPID)"
	if [[ "$0" == "$BASH_SOURCE" ]]; then
		echo "The script is executed directly."
	else
		echo "The script is being sourced."
	fi

	# get the current root device
	get_current_root_device

	# get the devices to be updated
	get_update_part
	get_update_device

	# create symlinks for the update process
    ln -sf $UPDATE_BOOT_DEV /dev/update-boot
	ln -sf $UPDATE_ROOT_DEV /dev/update-root

fi

if [ $1 == "postinst" ]; then

    # get the current root device
	get_current_root_device

    # get the devices to be updated
	get_update_part
    get_update_device

	fw_setenv mmcpart $UPDATE_BOOT_PART
    fw_setenv mmcroot "$UPDATE_ROOT_DEV rootwait rw"

	sync
fi
