import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

dependencies {
    implementation(project(":post-common"))
    implementation(project(":post-domain"))
    implementation(project(":post-application"))

    implementation("org.springframework.kafka:spring-kafka:3.0.11")
}
