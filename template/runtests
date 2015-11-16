#!/bin/bash

for x in tests/*.in; do
    if [ -e ${x%.in}.import ]; then
        java -cp edt-support.jar:po-uilib.jar:pt:. -Dimport=${x%.in}.import -Din=$x -Dout=${x%.in}.outhyp edt.textui.Editor;
    else
        java -cp edt-support.jar:po-uilib.jar:pt:. -Din=$x -Dout=${x%.in}.outhyp edt.textui.Editor ;
    fi

    diff -cB -w ${x%.in}.out ${x%.in}.outhyp > ${x%.in}.diff ;
    if [ -s ${x%.in}.diff ]; then
        echo "FAIL: $x. See file ${x%.in}.diff " ;
    else
        echo -n "."
        rm -f ${x%.in}.diff ${x%.in}.outhyp ; 
    fi
done

rm -f *.dat

echo "Done."

