# test_prehiring

## Purpose

This project is a part of interview. Please don't use it as case study.

## Prequiste
1. JDK (1.8 or above)
2. Maven
3. Intellij IDEA IDE

## Setup

Clone project to your local machine with this command `git clone <repository URL>`

**Setup JDK:**
  1. Download JDK from here https://www.oracle.com/java/technologies/javase-jdk15-downloads.html
  2. Install and setup JAVA_HOME in system properties. Please follow https://mkyong.com/java/how-to-set-java_home-on-windows-10/ to setup
  3. Run command `$ javac -version` to check the result. The output shoud be 
  > javac 1.8.0_231

**Setup Maven:**
  1. Download latest maven version from here http://maven.apache.org/download.cgi
  2. Install and setup MAVEN_HOME in system properties. Please follow https://mkyong.com/maven/how-to-install-maven-in-windows/ section 2 for config Maven
  3. Run command `$ mvn -version ` to check the result. The output should be
  > Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
Maven home: /usr/local/Cellar/maven/3.6.3_1/libexec
Java version: 14.0.1, vendor: N/A, runtime: /usr/local/Cellar/openjdk/14.0.1/libexec/openjdk.jdk/Contents/Home
Default locale: en_VN, platform encoding: UTF-8
OS name: "mac os x", version: "10.15.6", arch: "x86_64", family: "mac"

## Usage:
  
  1. Access to repository and run cmd.
  2. run command `$ mvn clean test -DsuiteXMLFile=testng.xml` to run test 
  
