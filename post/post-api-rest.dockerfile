FROM gradle:8.3.0-jdk17 as builder
WORKDIR /app

COPY settings.gradle.kts build.gradle.kts ./
COPY gradle ./gradle
COPY gradlew gradlew.bat ./

COPY post-common ./post-common
COPY post-domain ./post-domain
COPY post-application ./post-application
COPY post-adapter/kafka ./post-adapter/persistence
COPY post-adapter/mongo ./post-adapter/redis
COPY post-api/rest ./post-api/rest
RUN gradle clean :post-api-rest:bootJar --no-daemon

FROM openjdk:17-jdk-slim
COPY --from=builder /app/post-api/rest/build/libs/*.jar /app/
WORKDIR /app
EXPOSE 8080
CMD ["/bin/sh", "-c", "java -jar post-api-rest*.jar"]
