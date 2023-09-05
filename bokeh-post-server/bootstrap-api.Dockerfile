FROM gradle:8.3.0-jdk17 as builder
WORKDIR /app

COPY settings.gradle.kts build.gradle.kts ./
COPY gradle ./gradle
COPY gradlew gradlew.bat ./

COPY bokeh-post-domain ./bokeh-post-domain
COPY bokeh-post-framework ./bokeh-post-framework
COPY bokeh-post-application ./bokeh-post-application
COPY bokeh-post-bootstrap-api ./bokeh-post-bootstrap-api
RUN gradle clean :bokeh-post-bootstrap-api:bootJar --no-daemon

FROM openjdk:17-jdk-slim
COPY --from=builder /app/bokeh-post-bootstrap-api/build/libs/*.jar /app/
WORKDIR /app
EXPOSE 8080
CMD ["/bin/sh", "-c", "java -jar bokeh-post-bootstrap*.jar"]
