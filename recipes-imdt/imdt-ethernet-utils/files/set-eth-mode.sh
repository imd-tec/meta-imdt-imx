#!/bin/bash
#: Title        : set-eth-mode.sh
#: Author       : Lewis Purvis <lewisp@imd-tec.com>
#: Description  : Set the ethernet into adhoc mode

function display_usage
{
    echo -e ""
    echo -e "Usage:"
    echo -e ""
    echo -e "$0 [1|2]"
    echo -e ""
    echo -e "\t1 : LAN mode - Connect to an existing network. Expects DHCP server elsewhere on network."
    echo -e "\t    fallsback to default ip address if not found."
    echo -e ""
    echo -e "\t2 : ADHOC mode - Connect directly to another machine. This sets a static ip address for the device"
    echo -e "\t    and uses a dhcp server to lease an ip addres to whatever device you wish to connect to it."
    echo -e ""
    exit 1
}

. /opt/imdt/ethernet/ethernet-lib.sh

# Check command line arguments
if [ $# -ne 1 ]; then
  display_usage
  exit 0
fi

if ! [ $1 -eq 1 ] && ! [ $1 -eq 2 ]; then
  echo "Invalid input argument"
  display_usage
  exit 1
fi


# Correct behaviour depends on the mode
MODE=`/opt/imdt/ethernet/get-eth-mode.sh`

# where lan == 1
if [ $MODE == "LAN" ] 
then
    if [ $1 == 1 ]
    then
        echo "Ethernet is already in LAN mode"
        exit 0
    else
        enable_ethernet_network_unit
        echo "Ethernet set to ADHOC mode."
    fi
elif [ $MODE == "ADHOC" ]
then
  if [ $1 == 2 ]
    then
        echo "Ethernet is already in ADHOC mode"
        exit 0
    else
        disable_ethernet_network_unit
        echo "Ethernet set to LAN mode."
    fi
else
    echo "Error: unrecognised ethernet mode!"
    exit 1
fi



