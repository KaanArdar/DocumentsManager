FROM java:8

MAINTAINER Kaan Ardar ardarkaan@gmail.com

EXPOSE 8081

WORKDIR /opt

# Add & Run Microservice
ADD documentsmanager-0.0.1-SNAPSHOT.jar /opt/
ADD application.properties /opt/

ENTRYPOINT ["java", "-Xmx256m", "-Xms128m", "-jar", "documentsmanager-0.0.1-SNAPSHOT.jar"]
