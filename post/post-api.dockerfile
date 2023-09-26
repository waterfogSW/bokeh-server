FROM gradle:8.3.0-jdk17 as builder
WORKDIR /app

COPY settings.gradle.kts build.gradle.kts ./
COPY gradle ./gradle
COPY gradlew gradlew.bat ./

COPY post-domain ./post-domain
COPY post-application ./post-application
COPY post-infra-kafka ./post-infra-kafka
COPY post-bootstrap-api ./post-bootstrap-api
RUN gradle clean :post-bootstrap-api:bootJar --no-daemon

FROM openjdk:17-jdk-slim
COPY --from=builder /app/post-bootstrap-api/build/libs/*.jar /app/
WORKDIR /app
EXPOSE 8080
CMD ["/bin/sh", "-c", "java -jar post-bootstrap-api*.jar"]
