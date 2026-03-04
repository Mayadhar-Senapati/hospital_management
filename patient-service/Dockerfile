# -------- Build stage --------
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /build

# Copy project files
COPY pom.xml .
COPY src ./src

# Build the jar
RUN mvn clean package -DskipTests


# -------- Runtime stage --------
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy built jar
COPY --from=builder /build/target/*.jar app.jar

EXPOSE 8083

ENTRYPOINT ["java","-jar","app.jar"]