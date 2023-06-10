# Use the official Tomcat image from the Docker Hub
FROM tomcat:9.0.58-jdk17-openjdk-slim
# FROM amazoncorretto:17-alpine3.17

# Remove the default webapps that comes with the Tomcat image
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the WAR file from [gitlab target directory] to Tomcat webapps directory in local container
COPY target/*.war $CATALINA_HOME/webapps/group09.war
# CMD ["java", "-jar", "target/group09-0.0.1-SNAPSHOT.war"]

EXPOSE 8080

# The command to run when the container starts
# CMD ["catalina.sh", "run"]