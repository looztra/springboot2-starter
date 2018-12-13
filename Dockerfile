FROM fabric8/java-alpine-openjdk8-jdk:1.5.2

EXPOSE 8080 5005
ENV AB_OFF= \
    JAVA_DIAGNOSTICS= \
    JAVA_APP_DIR=/app

COPY target/sb2-starter-1.0.0-SNAPSHOT.jar /app/

