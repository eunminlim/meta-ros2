# Copyright (c) 2013-2017 LG Electronics, Inc.

DESCRIPTION = "LG WebOS edition of Simple DirectMedia Layer True Type Font library"
AUTHOR = "Seokhyon Seong <seokhyon.seong@lge.com>"
SECTION = "libs"

LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=cb33e7c4df9fbde389f149ad6bc93ce5"

inherit autotools
inherit webos_enhanced_submissions
inherit lib_package
inherit pkgconfig

DEPENDS = "virtual/libsdl wayland freetype"

WEBOS_VERSION = "2.0.14-12_3b0b5dbb2221c34c5d4c5b0ca010d8f12e755231"
PR = "r5"

SRC_URI = "${WEBOS_PRO_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"

EXTRA_OECONF += "SDL_CONFIG=${STAGING_BINDIR_CROSS}/sdl-config"

do_configure_prepend() {
    MACROS="libtool.m4 lt~obsolete.m4 ltoptions.m4 ltsugar.m4 ltversion.m4"
    for i in ${MACROS}; do
        rm -f ${S}/acinclude/$i
    done
}
