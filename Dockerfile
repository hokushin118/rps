#
# Build stage
#
FROM maven:3.5-jdk-8-alpine AS build
COPY src /home/rps-app/src
COPY pom.xml /home/rps-app
RUN mvn -f /home/rps-app/pom.xml clean install

#
# Package stage
#
FROM alpine:latest 
RUN apk --update add openjdk8-jre
COPY --from=build /home/rps-app/target/rps-app-0.0.1-SNAPSHOT.jar /usr/local/lib/rps-app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/usr/local/lib/rps-app.jar"]
CMD [""]