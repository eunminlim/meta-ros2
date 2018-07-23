# Copyright (c) 2013-2018 LG Electronics, Inc.

SUMMARY = "webOS C++ shared library containing a collection of common generic helper classes used for native application development."
AUTHOR = "Seokhyon Seong <seokhyon.seong@lge.com>"
SECTION = "webos/libs"
LICENSE = "CLOSED"

DEPENDS = "glib-2.0 libpbnjson luna-service2 nyx-lib"

WEBOS_VERSION = "2.0.0-54_29af215e947c7a3462eb5809151628aeb13e10cf"
PR = "r0"

inherit webos_component
inherit webos_enhanced_submissions
inherit webos_cmake
inherit webos_library

SRC_URI = "git://gpro.lgsvl.com:29418/webos-pro/libwebos-helpers.git;protocol=ssh"
S = "${WORKDIR}/git"
