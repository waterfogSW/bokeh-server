import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

jar.enabled = true
bootJar.enabled = false

dependencies {
    implementation(project(":post-common"))
    implementation(project(":post-domain"))
    implementation(project(":post-application"))

    api("org.springframework.kafka:spring-kafka:3.0.4")
}
