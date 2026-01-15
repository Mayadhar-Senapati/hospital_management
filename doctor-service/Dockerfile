# Use a lightweight JRE image (no compiler)
FROM eclipse-temurin:21-jre

# Set working directory inside container
WORKDIR /app

# Copy the Spring Boot executable JAR
COPY target/doctorService-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port (same as server.port)
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
