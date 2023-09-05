FROM gradle:8.3.0-jdk17 as builder
WORKDIR /app

COPY settings.gradle.kts build.gradle.kts ./
COPY gradle ./gradle
COPY gradlew gradlew.bat ./

COPY domain ./domain
COPY application ./application
COPY infrastructure ./infrastructure
COPY api ./api
RUN gradle clean :api:bootJar --no-daemon

FROM openjdk:17-jdk-slim
COPY --from=builder /app/api/build/libs/*.jar /app/
WORKDIR /app
EXPOSE 8080
CMD ["/bin/sh", "-c", "java -jar api*.jar"]
