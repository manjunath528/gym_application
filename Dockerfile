# Use an official OpenJDK image as a base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml files
COPY . /app/

# Build the Spring Boot app (compile it)
RUN ./mvnw clean package -DskipTests

# Expose the port your Spring Boot app will run on
EXPOSE 8080

# Run the Spring Boot app
CMD ["java", "-jar", "target/*.jar"]
