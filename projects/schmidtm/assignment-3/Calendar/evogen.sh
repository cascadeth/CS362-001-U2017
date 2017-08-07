#!/bin/bash

NUM_CORES=4         # Number of cores to use when generating tests
MEMORYUSE=4096      # The amount of RAM in Megabytes to use when generating tests

alias EVOGEN="mvn -DmemoryInMB=$MEMORY -Dcores=$NUM_CORES evosuite:generate"
export EVOGEN


printf "This will start EvoSuite's test generation with the following parameters:\n"
printf "    $NUM_CORES      CPU cores used\n"
printf "    $MEMORYUSE   MB of RAM used"
read -p "Are you sure? " -n 1 -r
echo    # (optional) move to a new line
if [[ $REPLY =~ ^[Yy]$ ]]
then
    EVOGEN
fi

sleep 10
mvn evosuite:info