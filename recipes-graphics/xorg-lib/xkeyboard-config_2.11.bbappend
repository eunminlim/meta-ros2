# Copyright (c) 2014-2017 LG Electronics, Inc.

# Using this .bbappend to fetch from a webOS Pro repo instead of from the
# upstream tarball. The strangeness of having a .bbappend and a .bb in the same
# directory will go away once we move to Yocto 1.6 and start using its .bb .

EXTENDPRAUTO_append = "pro1"

inherit webos_enhanced_submissions

# 2.11 upstream release + 36 upstream changes + webOS specific changes
WEBOS_VERSION = "2.11+36-15_104c057fc8b45db424a85da9be992067a0fba2eb"

SRC_URI = "${WEBOS_PRO_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"
