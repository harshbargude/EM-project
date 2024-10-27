FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/EM-project-0.0.1-SNAPSHOT.jar EM-project.jar
ENTRYPOINT ["java","-jar","/EM-project.jar"]