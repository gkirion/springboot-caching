FROM openjdk:11-jdk-slim-buster
MAINTAINER george kyritsas
COPY target/springboot-caching-1.0-SNAPSHOT.jar springboot-caching.jar
ENTRYPOINT ["java", "-jar", "springboot-caching.jar"]