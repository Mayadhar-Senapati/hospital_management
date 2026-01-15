# Use a lightweight JRE image (no compiler)
FROM eclipse-temurin:21-jre

# Set working directory inside container
WORKDIR /app

# Copy the Spring Boot executable JAR
COPY target/patient-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port (same as server.port)
EXPOSE 8083

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
