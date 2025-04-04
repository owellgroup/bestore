# Use an official JDK 23 image
FROM eclipse-temurin:23-jdk

# Set working directory inside the container
WORKDIR /app

# Copy project files
COPY . /app

# Grant execute permissions to Maven wrapper
RUN chmod +x ./mvnw

# Package the application
RUN ./mvnw clean package -DskipTests

# Expose port
EXPOSE 8080

# Run the Spring Boot app
CMD ["java", "-jar", "target/beststore-0.0.1-SNAPSHOT.jar"]
