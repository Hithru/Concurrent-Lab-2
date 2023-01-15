#!/bin/bash

# Compile the Java files
javac Main.java SenateBus.java

# Run the program
if [[ $? -eq 0 ]]; then
    java Main
fi
