FROM eclipse-temurin:17-jre-alpine

WORKDIR /usr/src/app

COPY target/*.jar application.jar

EXPOSE 8085

ENTRYPOINT java -jar application.jar
