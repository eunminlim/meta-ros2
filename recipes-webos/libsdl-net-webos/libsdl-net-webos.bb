# Copyright (c) 2013-2017 LG Electronics, Inc.

DESCRIPTION = "Simple DirectMedia Layer Network library."
AUTHOR = "Seokhyon Seong <seokhyon.seong@lge.com>"
SECTION = "libs"

LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=fe9d52a78585a65224776875510ed127"

inherit lib_package
inherit pkgconfig
inherit autotools
inherit webos_enhanced_submissions

DEPENDS = "virtual/libsdl"

WEBOS_VERSION = "2.0.1-6_df5d54fb5570ad4fcecfb666993b394ab3068f21"
PR = "r6"

SRC_URI = "${WEBOS_PRO_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"

do_configure_prepend() {
   MACROS="libtool.m4 lt~obsolete.m4 ltoptions.m4 ltsugar.m4 ltversion.m4"
   for i in ${MACROS}; do
     rm -f ${S}/acinclude/$i
   done
}
