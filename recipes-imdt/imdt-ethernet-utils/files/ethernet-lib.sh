#: Title        : ethernet-lib.sh
#: Author       : Paul Thomson <pault@imd-tec.com>, Lewis Purvis <lewisp@imd-tec.com>
#: Description  : Library of functions for use by the Ethernet control scripts


function enable_ethernet_network_unit
{
    pushd /lib/systemd/network 1>/dev/null
    mv 19-eth0.network.disabled 19-eth0.network 2>/dev/null
    popd 1>/dev/null

    systemctl restart systemd-networkd
}

function disable_ethernet_network_unit
{
    pushd /lib/systemd/network 1>/dev/null
    mv 19-eth0.network 19-eth0.network.disabled 2>/dev/null
    popd 1>/dev/null

    systemctl restart systemd-networkd
}

function take_down_eth0
{
    ip link set eth0 down
}

function bring_up_eth0
{
    ip link set eth0 up
}