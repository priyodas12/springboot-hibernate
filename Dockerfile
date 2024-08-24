# Use the official OpenJDK image from the Docker Hub
FROM openjdk:17-jdk-slim

# Add a volume pointing to /tmp
VOLUME /tmp

# Copy the application's jar file to /app.jar
COPY target/springboot-hibernate-0.0.1-SNAPSHOT.jar /app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]
