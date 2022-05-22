#!/bin/sh
if [ $# -ne 1 ]
then
    echo 'Invalid amount of parameters.'
    echo Syntax: $0 foldername
    exit 1
fi
folders=`find "$1" -empty -printf "%f\n"`
echo $folders >> emptysubfolder.txt
