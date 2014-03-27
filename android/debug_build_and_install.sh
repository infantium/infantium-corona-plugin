#!/bin/bash

./build.sh

if [ ! -z "$1" ]
then
	APK_NAME=$1
else
	echo '###############################################'
	echo '## APK not signed. Pass the APK file name    ##' 
	echo '## as an argument to get it signed as debug. ##'
	echo '###############################################'
	exit -1
fi

jarsigner -verbose -sigalg SHA1withRSA -digestalg SHA1 -keystore debug.keystore -keypass android -storepass android $APK_NAME androiddebugkey

adb install -r $APK_NAME

if [ ! -z "$2" ]
then
	adb shell am force-stop $2
	adb shell am start -n "$2/$3"
else
	echo '####################################################'
        echo '## APK not launched. Pass the APK package name    ##'
        echo '## and activity name in the following format:     ##'
	echo '## "packagename activityname" to get it launched. ##'
        echo '####################################################'
	exit -1
fi

