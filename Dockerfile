FROM openjdk:11
ARG JAR_FILE=build/libs/HRI_Web_Backend-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} HRI_Web_Backend.jar
ENTRYPOINT ["java","-jar","/HRI_Web_Backend.jar"]
EXPOSE 8080