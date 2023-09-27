FROM gradle:8.3.0-jdk17 as builder
WORKDIR /app

COPY settings.gradle.kts build.gradle.kts ./
COPY gradle ./gradle
COPY gradlew gradlew.bat ./

COPY user-common ./user-common
COPY user-domain ./user-domain
COPY user-application ./user-application
COPY user-adapter/persistence ./user-adapter/persistence
COPY user-adapter/redis ./user-adapter/redis
COPY user-api/rest ./user-api/rest
RUN gradle clean :user-api-rest:bootJar --no-daemon

FROM openjdk:17-jdk-slim
COPY --from=builder /app/user-api/rest/build/libs/*.jar /app/
WORKDIR /app
EXPOSE 8080
CMD ["/bin/sh", "-c", "java -jar user-api-rest*.jar"]
