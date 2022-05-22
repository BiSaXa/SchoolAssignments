#!/bin/bash
if [ $# -gt 1 ]
then
    echo 'Invalid amount of parameters.'
    echo Syntax: $0 '<directory>'
    exit 1
fi
ls -p $1 | grep -v /
