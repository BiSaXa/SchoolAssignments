#!/bin/bash
if [ $# -eq 0 ]
then
    echo "Error - Number missing from the command line argument"
    echo "Syntax: $0 number"
    echo "Use to print if number is even or odd"
    exit 1
fi
n=$1
if [ $(($n % 2)) -eq 0 ]
then
    echo "$n is even."
else
    echo "$n is odd."
fi
