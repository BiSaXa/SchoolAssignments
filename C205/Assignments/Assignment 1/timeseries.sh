#!/bin/bash
echo "Enter n:"
read n
sum=0
for ((i = 0; i <= $n; i++)); do
    sum=`expr $sum + $i`
done
echo $sum
