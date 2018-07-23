# Copyright (c) 2015-2017 LG Electronics, Inc.

EXTENDPRAUTO_append = "pro4"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

DEPENDS_append_class-target = " pmloglib"
EXTRA_OECONF_append_class-target = " --enable-pmlog"

SRC_URI += " \
    file://0001-Support-dynamic-turning-on-off-wayland-debug.patch \
    file://0002-Support-log-redirection-for-wayland-debug.patch \
    file://0003-Enhance-logging-for-wayland-error-detection.patch \
    file://0005-server-Fix-crash-when-accessing-client-which-is-alre.patch \
"
