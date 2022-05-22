#!/bin/bash
if [ $# -ne 1 ]
then
    echo 'Invalid amount of parameters.'
    echo Syntax: $0 foldername
    exit 1
fi
find $1 -type d -ls | wc -l
