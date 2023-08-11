# verbose-sniffle
This project is a command line utility for sorting data (integers or strings) into a specified order and writing the result to an output file.

Java version: 
openjdk version "20.0.1" 2023-04-18
OpenJDK Runtime Environment (build 20.0.1+9-29)
OpenJDK 64-Bit Server VM (build 20.0.1+9-29, mixed mode, sharing)

Сompilation command:
javac -d out -sourcepath src src/merge/MergeSortedFiles.java   

Run command:
java -cp %PATH%\merge_sort\out\ merge.MergeSortedFiles merge.MergeSortedFiles -dataType -cast outputFile inputFiles

dataType:
Use '-i' or '-s' to choose between strig and int. Кequired parameter.

-cast: 
Use '-a' or '-d' to choose ascending or descending entry. Optional parameter.

outputFile: 
Write the path to the file.

inputFiles:
Provide at least one input file.
