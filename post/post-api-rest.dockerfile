FROM gradle:8.3.0-jdk17 as builder
WORKDIR /app

COPY settings.gradle.kts build.gradle.kts ./
COPY gradle ./gradle
COPY gradlew gradlew.bat ./

COPY post-common ./user-common
COPY post-domain ./user-domain
COPY post-application ./user-application
COPY post-adapter/kafka ./user-adapter/persistence
COPY post-adapter/mongo ./user-adapter/redis
COPY post-api/rest ./user-api/rest
RUN gradle clean :user-api-rest:bootJar --no-daemon

FROM openjdk:17-jdk-slim
COPY --from=builder /app/user-api/rest/build/libs/*.jar /app/
WORKDIR /app
EXPOSE 8080
CMD ["/bin/sh", "-c", "java -jar user-api-rest*.jar"]
