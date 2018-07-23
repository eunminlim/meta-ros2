# Copyright (c) 2013-2017 LG Electronics, Inc.

DESCRIPTION = "Simple DirectMedia Layer Audio Mixer library."
AUTHOR = "Seokhyon Seong <seokhyon.seong@lge.com>"
SECTION = "libs"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=aa62930939266a164b1214c52b9c8627"

inherit lib_package
inherit pkgconfig
inherit autotools-brokensep
inherit webos_enhanced_submissions

DEPENDS = "virtual/libsdl wayland flac libmikmod libvorbis libsmpeg-webos"
RDEPENDS_${PN} = "flac libmikmod libvorbis libsmpeg-webos"

WEBOS_VERSION = "2.0.1-10_af5b9ed69d08608417cdc1b15cdbba40399f6c7a"
PR = "r6"

WEBOS_REPO_NAME = "libsdl-mixer-webos"
SRC_URI = "${WEBOS_PRO_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"

EXTRA_OECONF += "--with-sysroot=${STAGING_DIR_HOST} --disable-music-mod"

PACKAGECONFIG[wayland] = ",,wayland"

do_configure () {
    sh ${S}/autogen.sh
    oe_runconf

    #rpath fix for SDL's libtool
    sed -i 's|^hardcode_libdir_flag_spec=.*|hardcode_libdir_flag_spec=""|g' ${S}/libtool
    sed -i 's|^runpath_var=LD_RUN_PATH|runpath_var=DIE_RPATH_DIE|g' ${S}/libtool
}
