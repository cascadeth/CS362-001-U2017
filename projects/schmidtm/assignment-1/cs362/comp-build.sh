#!/bin/bash

# Simply compile the Maven project, then build it

printf "Starting compilation...\n\n"
mvn compile
printf "\n\n"
printf "Starting test generations...\n\n"

# Run a long command to generate EvoSuite's tests
/c/Program\ Files/Java/jdk1.8.0_131/bin/java -jar ./bin/evosuite-1.0.5.jar -class edu.osu.cs362.Life -projectCP ./target/classes
printf "\n\n"
printf "Starting packager...\n\n"
mvn package
printf "\n\n"
printf "Complete!\n\n"
exit
