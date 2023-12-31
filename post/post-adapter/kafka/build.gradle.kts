import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

jar.enabled = true
bootJar.enabled = false

dependencies {
    implementation(project(":post-common"))
    implementation(project(":post-domain"))
    implementation(project(":post-application"))

    implementation("org.springframework.boot:spring-boot")
    api("org.springframework.kafka:spring-kafka:3.0.11")
    api("org.springframework.kafka:spring-kafka-test:3.0.11")
}
