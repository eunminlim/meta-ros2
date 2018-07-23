# Copyright (c) 2015-2017 LG Electronics, Inc.

AUTHOR = "Kirill Dmitriev <kirill.dmitriev@lge.com>"
EXTENDPRAUTO_append = "pro5"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += "file://0001-Raw-device-added.patch \
            file://0002-Applying-transformation-matrices-to-svg.patch \
            file://0003-Implement-support-for-SVG-batch-rendering.patch \
"

PACKAGECONFIG_append_class-target = " egl glesv2"

VIRTUAL-RUNTIME_gpu-libs ?= ""
RDEPENDS_${PN}-gobject_append_class-target = " ${VIRTUAL-RUNTIME_gpu-libs}"
RDEPENDS_${PN}-script-interpreter_append_class-target = " ${VIRTUAL-RUNTIME_gpu-libs}"
RDEPENDS_${PN}_append_class-target = " ${VIRTUAL-RUNTIME_gpu-libs}"
