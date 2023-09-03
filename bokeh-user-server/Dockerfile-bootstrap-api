FROM gradle:8.3.0-jdk17 as builder
WORKDIR /app

COPY settings.gradle.kts build.gradle.kts ./
COPY gradle ./gradle
COPY gradlew gradlew.bat ./

COPY bokeh-user-domain ./bokeh-user-domain
COPY bokeh-user-framework ./bokeh-user-framework
COPY bokeh-user-application ./bokeh-user-application
COPY bokeh-user-bootstrap-api ./bokeh-user-bootstrap-api
RUN gradle clean :bokeh-user-bootstrap-api:bootJar --no-daemon

FROM openjdk:17-jdk-slim
COPY --from=builder /app/bokeh-user-bootstrap-api/build/libs/*.jar /app/
WORKDIR /app
EXPOSE 8080
CMD ["/bin/sh", "-c", "java -jar bokeh-user-bootstrap*.jar"]
