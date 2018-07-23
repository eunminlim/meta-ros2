# Copyright (c) 2013-2017 LG Electronics, Inc.

DESCRIPTION = "LG WebOS edition of Simple DirectMedia Layer Image library"
SUMMARY = "webOS image decoding add-on for SDL."
AUTHOR = "Seokhyon Seong <seokhyon.seong@lge.com>"
SECTION = "webos/libs"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=ec65b9778f5584a0bd8dfc17d6340ba0"

inherit webos_component
inherit webos_enhanced_submissions
inherit autotools-brokensep
inherit lib_package
inherit pkgconfig

DEPENDS = "virtual/libsdl wayland zlib jpeg libpng tiff "
RDEPENDS_${PN} = "libpng tiff"

WEBOS_VERSION = "2.0.1-10_4aaf666bec52e05cc2af5ef507dbd036d9739613"
PR = "r9"

SRC_URI = "${WEBOS_PRO_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"

EXTRA_OECONF += "--with-sysroot=${STAGING_DIR_HOST}"

do_configure () {
    rm -f ${S}/aclocal.m4
    rm -f ${S}/configure
    rm -f ${S}/Makefile
    sh ${S}/autogen.sh
    oe_runconf

    #rpath fix for SDL's libtool
    sed -i 's|^hardcode_libdir_flag_spec=.*|hardcode_libdir_flag_spec=""|g' ${S}/libtool
    sed -i 's|^runpath_var=LD_RUN_PATH|runpath_var=DIE_RPATH_DIE|g' ${S}/libtool
}
