#!/bin/bash

# compile the calendar files
mvn compile

# Pause to show previous results
printf "\n\n Script execution paused for 10 seconds... \n\n"
sleep 10
printf "Running student written tests...\n\n"
sleep 2

# Run the student written tests
mvn test

exit 0