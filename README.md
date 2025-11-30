# OOP supervision 1
## Setup
1. Clone the repo
2. Install [Maven](https://maven.apache.org/) (if not already installed)

## Running files individually
### From IntelliJ (recommended)
Simply right-click on a file and the select `run`.

### From the command line [^1]
1. Run `mvn install` to compile the code
2. Run `java -cp target/classes uk.ac.cam.mp2226.part1a.oop.supo2.<classname>` to run a class

## Running all tests
### From IntelliJ
Right-click on `src/test/java` and select `Run 'All Tests'`

### From the command line [^1]
Run `mvn verify`



[^1]: Some form of bash is recommended (e.g. Git Bash on Windows, the builtin bash where it is available). I have not and will not test any commands on any other shell

