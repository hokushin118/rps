# Rock Paper Scissors game with Markov Chain for AI
[![CircleCI](https://circleci.com/gh/hokushin118/rps/tree/master.svg?style=svg)](https://circleci.com/gh/hokushin118/rps/tree/master)
[![codecov](https://codecov.io/gh/hokushin118/rps/branch/master/graph/badge.svg?token=8FSYV51XAF)](https://codecov.io/gh/hokushin118/rps)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=hokushin118_rps&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=hokushin118_rps)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/ae18bc7d448c4b9ab13811b1b08f6c13)](https://app.codacy.com/gh/hokushin118/rps?utm_source=github.com&utm_medium=referral&utm_content=hokushin118/rps&utm_campaign=Badge_Grade_Settings)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
### Prerequisites
* Java 11 or higher
### Technology stack
* OpenJDK 11
* Maven 3.6.0
* Lombok 1.18.20
* JUnit 5.8.2
* Mockito 3.9.0
* CircleCI 2.0 for CI/CD
* SonarCloud for SAST
### Running the RPS Game From the Command Line
* Clone this repository:
```
    $ git clone https://github.com/hokushin118/rps.git
```
* Navigate to the rooy directory of the application on your computer.
* Run "mvn package" in the root directory to create the Rock Paper Scissors game console app.
```
     > mvn package
```
* Run "java -jar target/rps-app.jar" in the root directory to launch the Rock Paper Scissors game console app.
```
     > java -jar target/rps-app.jar
```
### Creating and uploading Docker image to a Docker Hub repository
#### Rock Paper Scissors app is very easy to install and deploy in a Docker container
* Create a Docker Hub account if you don't have one.
* Change the lines below in you pom.xml file under the < properties > node:
```
     <docker-hub-user-id>your-docker-hub-user-name</docker-hub-user-id>
```
* Change the lines below in you pom.xml file under the < to > node of the jib-maven-plugin:
```
     <auth>
           ...
           <password>your-docker-password</password>
     </auth>
```
* Run the Rock Paper Scissors application under docker profile "mvn clean install -Pdocker" to create and upload RPS game Docker image to a Docker Hub repository.
```
    > mvn clean install -Pdocker
```
