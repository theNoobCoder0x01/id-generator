FROM openjdk:17
COPY target/id-generator-0.0.1-SNAPSHOT.jar id-generator-0.0.1-SNAPSHOT.jar
EXPOSE 4202
ENTRYPOINT ["java", "-jar", "/id-generator-0.0.1-SNAPSHOT.jar"]