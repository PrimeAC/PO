# Makefile 

all:  
	javac -cp po-uilib.jar:.:edt-support.jar `find edt -name *.java`

run: 
	java -cp po-uilib.jar:.:edt-support.jar edt.textui.Editor

clear:
	find . -name "*.class" -type f -print0 | xargs -0 rm -f

