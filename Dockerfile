# Use Eclipse Temurin JDK 25 image
FROM eclipse-temurin:25-jdk

WORKDIR /app
COPY target/SpingBootProject-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
