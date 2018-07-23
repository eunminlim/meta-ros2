# Copyright (c) 2013-2017 LG Electronics, Inc.

SUMMARY = "WebOS edition of Simple DirectMedia Layer"
DESCRIPTION = "Simple DirectMedia Layer is a cross-platform multimedia \
library designed to provide low level access to audio, keyboard, mouse, \
joystick, 3D hardware via OpenGL, and 2D video framebuffer."
HOMEPAGE = "http://www.libsdl.org"
BUGTRACKER = "http://bugzilla.libsdl.org/"

AUTHOR = "Seokhyon Seong <seokhyon.seong@lge.com>"
SECTION = "libs"

LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=67dcb7fae16952557bc5f96e9eb5d188"

PROVIDES = "virtual/libsdl"

inherit webos_enhanced_submissions autotools-brokensep lib_package binconfig pkgconfig
inherit webos_machine_dep

DEPENDS = "wayland virtual/libgles2 udev libpng luna-surfacemanager-extensions pmloglib glib-2.0 libwebos-helpers libxkbcommon libpbnjson"

WEBOS_VERSION = "2.0.4-83_7f3027b3c01eef0729247a41161b8b026564fb26"
PR = "r20"

WEBOS_REPO_NAME = "libsdl-webos"
SRC_URI = "git://gpro.lgsvl.com:29418/webos-pro/libsdl.git;protocol=ssh"

S = "${WORKDIR}/git"

# Component's configure script isn't using pkg-config to find EGL implementation
# so it just includes EGL/egl.h which later causes
# EGL/eglplatform.h:118:22: fatal error: X11/Xlib.h: No such file o
CFLAGS += "-DMESA_EGL_NO_X11_HEADERS"

EXTRA_OECONF += "--enable-shared --enable-threads --enable-timers \
                --enable-file --disable-oss --disable-esd --disable-arts \
                --disable-diskaudio --disable-nas --disable-esd-shared --disable-esdtest \
                --disable-video-dummy \
                --enable-pthreads \
                --enable-video-wayland --enable-video-opengles \
                --enable-dependency-tracking --disable-xkbcommon \
                --disable-rpath --disable-input-tslib \
                --with-sysroot=$PKG_CONFIG_SYSROOT_DIR"

WAYLAND_EXTENSIONS_DEPENDS ?= ""
PACKAGECONFIG ??= "${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'pulseaudio', '', d)}"
#PACKAGECONFIG ??= "${@bb.utils.contains('DISTRO_FEATURES', 'alsa', 'alsa', '', d)}"
#If ALSA and pulseaudio are enabled simultaneously, SDL basically uses ALSA. SDL should use pulseaudio for controlling resource used by Audio-D.
PACKAGECONFIG[pulseaudio] = "--enable-pulseaudio,--disable-pulseaudio,pulseaudio,libpulse-simple"
PACKAGECONFIG[alsa] = "--enable-alsa,--disable-alsa,alsa-lib,"
PACKAGECONFIG[wayland-extensions] = "--enable-video-wayland-extensions,--disable-video-wayland-extensions,${WAYLAND_EXTENSIONS_DEPENDS}"

do_configure () {
    ${S}/autogen.sh
    oe_runconf

    #rpath fix for SDL's libtool
    sed -i 's|^hardcode_libdir_flag_spec=.*|hardcode_libdir_flag_spec=""|g' ${S}/libtool
    sed -i 's|^runpath_var=LD_RUN_PATH|runpath_var=DIE_RPATH_DIE|g' ${S}/libtool
}

# From https://gpro.lgsvl.com/165170
SRC_URI += "file://linkage.patch"

# From https://gpro.lgsvl.com/165176
SRC_URI += "file://0001-src-video-make-it-compatible-with-wayland-1.10.patch"
