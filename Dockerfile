#FROM openjdk:17-alpine
FROM amazoncorretto:17-al2-jdk

COPY target/*.jar /deployments/app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/deployments/app.jar"]