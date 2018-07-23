# Copyright (c) 2013-2017 LG Electronics, Inc.

AUTHOR = "Bhooshan Supe <bhooshan.supe@lge.com>"
EXTENDPRAUTO_append = "pro6"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Add-ignore-mtime-option-to-fc-cache.patch"
# Update the beginline and endline parameters, because the patch
# adds 5 new lines before it
# file://src/fccache.c;beginline=1199;endline=1214;md5=0326cfeb4a7333dd4dd25fbbc4b9f27f"
LIC_FILES_CHKSUM = "file://COPYING;md5=7a0449e9bc5370402a94c00204beca3d \
    file://src/fcfreetype.c;endline=45;md5=5d9513e3196a1fbfdfa94051c09dfc84 \
    file://src/fccache.c;beginline=1364;endline=1379;md5=0326cfeb4a7333dd4dd25fbbc4b9f27f \
"

do_install_append() {
    # remove the links to the config files from the fontconfig
    # component that conflict with the webOS config files
    rm -f ${D}${sysconfdir}/fonts/conf.d/*.conf
}
