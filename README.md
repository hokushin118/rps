# Rock Paper Scissors game with Markov Chain for AI
[![CircleCI](https://circleci.com/gh/hokushin118/rps/tree/main.svg?style=svg)](https://circleci.com/gh/hokushin118/rps/tree/main)
[![codecov](https://codecov.io/gh/hokushin118/rps/branch/main/graph/badge.svg?token=8FSYV51XAF)](https://codecov.io/gh/hokushin118/rps)

[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=hokushin118_rps&metric=bugs)](https://sonarcloud.io/summary/new_code?id=hokushin118_rps)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=hokushin118_rps&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=hokushin118_rps)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=hokushin118_rps&metric=coverage)](https://sonarcloud.io/summary/new_code?id=hokushin118_rps)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=hokushin118_rps&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=hokushin118_rps)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=hokushin118_rps&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=hokushin118_rps)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=hokushin118_rps&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=hokushin118_rps)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=hokushin118_rps&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=hokushin118_rps)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=hokushin118_rps&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=hokushin118_rps)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=hokushin118_rps&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=hokushin118_rps)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=hokushin118_rps&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=hokushin118_rps)

### Prerequisites
* Java 11 or higher.
* Maven 3.6.0 or higher.

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
#### Rock Paper Scissors app is very easy to install and deploy in a Docker container.
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
