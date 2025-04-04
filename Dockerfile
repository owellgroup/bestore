# Start from an OpenJDK 23 image
FROM eclipse-temurin:23-jdk

# Set the working directory
WORKDIR /app

# Copy Maven wrapper and project files
COPY . /app

# Package the application
RUN ./mvnw clean package -DskipTests

# Run the app
ENTRYPOINT ["java", "-jar", "target/beststore-0.0.1-SNAPSHOT.jar"]
