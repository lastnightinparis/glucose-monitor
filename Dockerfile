FROM openjdk:17-alpine
COPY target/glucose-monitor-0.0.1-SNAPSHOT.jar glucose-monitor-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/glucose-monitor-0.0.1-SNAPSHOT.jar"]
EXPOSE 8081 6380