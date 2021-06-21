FROM openjdk:11
LABEL maintainer="Josivaldo Batista"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "/application.jar"]
EXPOSE 8080