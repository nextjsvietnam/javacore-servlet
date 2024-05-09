# Stage 1: Build the application using Maven and JDK 11
FROM maven:3.8.6-openjdk-11 AS build

# Copy the application source code and pom.xml to the image
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app

# Set the working directory for the build stage
WORKDIR /usr/src/app

# Compile and package the application
RUN mvn clean package

# Stage 2: Create the final image using Tomcat 9 with JDK 11
FROM tomcat:9.0-jdk11-corretto

# Remove the default web applications from Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the WAR file from the build stage to the Tomcat webapps directory
COPY --from=build /usr/src/app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Set the working directory to Tomcat's folder
WORKDIR /usr/local/tomcat

# Expose the port Tomcat listens on
EXPOSE 8080

# Command to run Tomcat
CMD ["catalina.sh", "run"]