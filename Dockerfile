# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /usr/src/app/

# Install Maven
RUN apk --update add maven && \
    rm -rf /var/cache/apk/*

# Copy the JAR file from the host to the container
COPY ./application /usr/src/app/

# Expose the port your application is listening on (if applicable)
EXPOSE 8081

WORKDIR /usr/src/app/WerknemerService/

RUN mvn clean install

# Specify the default command to run your application
CMD ["java", "-jar", "target/startproject-0.0.1-SNAPSHOT.jar"]
