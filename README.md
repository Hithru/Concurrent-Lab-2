# README

## Prerequisites

- Make sure you have Java installed on your machine. You can check if it's installed by running `java -version` in the command line.
- Make sure you have a bash shell.

## Compiling and Running the program

1. Download the `Main.java`, `SenateBus.java` and the `compileAndRun.sh` files.
2. Open a terminal and navigate to the directory where the files are saved.
3. Make the script executable by running `chmod +x compileAndRun.sh`
4. Run the script by executing `./compileAndRun.sh`

The script will first compile the java files, then it will run the program. If the compilation is successful, the program will execute and the output will be displayed on the terminal.

Note: The output may vary each time the script is run due to the nature of the problem and the way threads are scheduled by the JVM.

## Conclusion

The above script helps in automating the process of compiling and running the java program which makes it easy to execute the program again and again without the need of compiling it manually.
