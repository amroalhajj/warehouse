FROM openjdk:8-jdk-alpine

MAINTAINER progressSoft

EXPOSE= 8000

ENTRYPOINT  ["java", "-jar", "warehouse.jar"]