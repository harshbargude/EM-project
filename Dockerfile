FROM openjdk:17-jdk-alpine
EXPOSE 8080
ADD target/emproject-0.0.1-SNAPSHOT.jar emproject.jar
ENTRYPOINT ["java","-jar","/emproject.jar"]