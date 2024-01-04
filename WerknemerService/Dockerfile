# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the application JAR file into the container at the specified working directory
COPY target/startproject-0.0.1-SNAPSHOT.jar .

# Specify the command to run on container start
CMD ["java", "-jar", "startproject-0.0.1-SNAPSHOT.jar"]