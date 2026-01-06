#@TYPE: Machine
#@NAME: IMDT Pico-E/EM Board [IM-PCA-0010]
#@SOC: i.MX8MP
#@DESCRIPTION: ARM tune fragment for IMX8MP using the general armv8a tuning  

require conf/machine/include/imx-base.inc

# Using a generic ARMv8-A architecture definition instead of the cortexa53 one.
# This allows building packages (e.g. onnxruntime) which use armv8a features supported in the 
# armv8a architecture and on IMX8MP but which are not compatible with the more specific 
# and optimized cortexa53 tuning. This is also the method used by NXP 
# meta-imx/meta-imx-sdk/conf/distro/include/fsl-imx-base.inc
require conf/machine/include/arm/arch-armv8a.inc 

# arch-armv8a.inc sets 'armv8a-crc' - add the crypto option as well for imx8m
DEFAULTTUNE:mx8m-nxp-bsp = "armv8a-crc-crypto"

