import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    implementation("org.slf4j:slf4j-api:1.7.32")
}

val jar: Jar by tasks
val bootJar: BootJar by tasks

jar.enabled = true
bootJar.enabled = false
