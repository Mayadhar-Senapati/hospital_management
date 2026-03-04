# ---------- Build stage ----------
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /build

# Copy project files
COPY pom.xml .
COPY src ./src

# Build the jar
RUN mvn clean package -DskipTests


# ---------- Run stage ----------
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy jar from builder stage
COPY --from=builder /build/target/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","app.jar"]