1 from the terminal (current directory) to create a jar exec-file:
mvn clean install assembly:single
2 from the target directory you can retrieve the jar with all dependencies needed
3 put the input file in input directory(if it does not exist create one in the same directory of the jar file);
4 create output directory(if it does not exist create one in the same directory of the jar file);
5 modify the fileConverter.properties (if it does not exist create one in the same directory of the jar file);
example of fileConverter.properties:
/*
inputFilePath=".\\input\\ServiceMenu.json"
outputFilePath=".\\output\\ServiceMenu.xlsx"
*/

6 run the jar file:
java -jar jsonToExcelTest-0.0.1-jar-with-dependencies.jar
