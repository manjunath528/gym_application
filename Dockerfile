# Use an official OpenJDK image as a base image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the project files
COPY . /app/

# Grant execute permissions to Maven wrapper
RUN chmod +x /app/mvnw

# Build the Spring Boot app (compile it)
RUN ./mvnw clean package -DskipTests

# Expose the port your Spring Boot app will run on
EXPOSE 8080

# Run the Spring Boot app
CMD ["java", "-jar", "target/GymApplication-0.0.1-SNAPSHOT.jar"]
