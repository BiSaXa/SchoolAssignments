#!/bin/bash
if [ $# -ne 3 ]
then
    echo "Error - Invalid amount of parameters missing from the command line argument"
    echo "Syntax: $0 foldername lowercase-char single-char/integer"
    exit 1
fi
if [[ $3 == [a-zA-Z] ]]
then
    echo "The third argument is a character"
    sumofc1=`grep -o "$2" $1 | wc -l`
    sumofc2=`grep -o "$3" $1 | wc -l`
    echo `expr $sumofc1 + $sumofc2`
elif [[ $3 == [0-9] ]]
then
    if [ $3 -gt 1 ]
    then
        echo "The third argument is an integer and greater than 1"
        for (( i = 0; i < "$3"; ++i ))
        do
            pattern+="$2"
        done
        n=`grep -o "$pattern" $1 | wc -l`
        echo $n
    elif [ $3 -eq 1 ]
    then
        echo "The third argument is an integer and equals to 1"
        n=`grep -o "[$2-z]" $1 | wc -l`
        echo $n
    fi
fi
