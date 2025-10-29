# Step 1: Build stage
FROM eclipse-temurin:25-jdk AS builder
WORKDIR /app

# Copy Maven files
COPY pom.xml .
COPY src ./src

# Build the application (skip tests for faster build)
RUN ./mvnw clean package -DskipTests || mvn clean package -DskipTests

# Step 2: Runtime stage
FROM eclipse-temurin:25-jdk
WORKDIR /app

# Copy only the built JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
