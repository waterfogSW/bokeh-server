FROM gradle:8.3.0-jdk17 as builder
WORKDIR /app

COPY settings.gradle.kts build.gradle.kts ./
COPY gradle ./gradle
COPY gradlew gradlew.bat ./

COPY user-domain ./user-domain
COPY user-application ./user-application
COPY user-infra-jpa ./user-infra-jpa
COPY user-bootstrap-api ./user-bootstrap-api
RUN gradle clean :user-bootstrap-api:bootJar --no-daemon

FROM openjdk:17-jdk-slim
COPY --from=builder /app/user-bootstrap-api/build/libs/*.jar /app/
WORKDIR /app
EXPOSE 8080
CMD ["/bin/sh", "-c", "java -jar user-bootstrap-api*.jar"]
