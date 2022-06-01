#
# Copyright (c) 2022 IMD Technologies
#

# Prioritise the systemd resolv.conf file over the one from the connman package
ALTERNATIVE_PRIORITY[resolv-conf] = "300"
