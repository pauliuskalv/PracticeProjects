#!/bin/bash

rm -r bin

#build the classpath
CLASSPATH=
for i in `find * -name "*.java"`
do
  CLASSPATH=${CLASSPATH}\ ${i}
done

mkdir bin

javac -d bin ${CLASSPATH}

cd bin

#TODO
#Add arguments to program like framerate and etc.
java gui.UIController
