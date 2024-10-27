FROM maven:3.8.5-openjdk-17 As build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-alpine
COPY --from=build target/EM-project-0.0.1-SNAPSHOT.jar EM-project.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/EM-project.jar"]
