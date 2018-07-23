# Copyright (c) 2017 LG Electronics, Inc.

EXTENDPRAUTO_append = "pro3"

inherit pkgconfig

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-wscript-use-pkg-config-to-find-EGL-GLESv2-libs.patch"

VIRTUAL-RUNTIME_gpu-libs ?= ""
RDEPENDS_${PN} += "${VIRTUAL-RUNTIME_gpu-libs}"
