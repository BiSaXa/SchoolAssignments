#!/bin/bash
if [ $# -gt 9 ]
then
    echo 'Parameter count should not be more than 9.'
    exit 1
fi
sum=0
for i do
    if [ $i -gt 10 ]
    then
        sum=(`expr $sum + $i`)
    fi
done
echo $sum
