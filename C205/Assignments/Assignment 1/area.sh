#!/bin/bash
echo "Choose your desired object to calculate its area:"
echo "1. Circle"
echo "2. Rectangle"
read object
if [ "$object" = "1" ]
then
    echo "Enter the radius:"
    read radius
    area=$(awk "BEGIN {print 3.1415 * $radius * $radius }")
    echo "Area is: $area"
elif [ "$object" = "2" ]
then
    echo "Enter first side length:"
    read l1
    echo "Enter second side length:"
    read l2
    echo "Area is: `expr $l1 \* $l2`"
else
    echo "Invalid object selected."
    echo "Write 1 for circle, 2 for rectangle."
fi 
