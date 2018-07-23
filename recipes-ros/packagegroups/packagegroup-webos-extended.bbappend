# Copyright (c) 2017-2018 LG Electronics, Inc.

# You don't need to change this value when you're changing just a RDEPENDS_${PN} variable.
EXTENDPRAUTO_append = "ros1"

RDEPENDS_${PN}_append = " \
    actionlib-msgs \
    diagnostic-msgs \
    geometry-msgs \
    nav-msgs \
    packagegroup-ros2-world \
    rosbash \
    roscpp \
    roscpp-tutorials \
    roslaunch \
    rosmsg \
    rosnode \
    rosservice \
    rostopic \
    ros1-bridge \
    ros2cli \
    ros2msg \
    ros2run \
    ros2topic \
    ros2pkg \
    ros2node \
    ros2srv \
    ros2service \
    sensor-msgs \
    std-msgs \
    turtlebot3 \
    turtlebot3-bringup \
    turtlebot3-description \
    turtlebot3-navigation \
    turtlebot3-slam \
    turtlebot3-teleop \
    move-base \
    amcl \
"
