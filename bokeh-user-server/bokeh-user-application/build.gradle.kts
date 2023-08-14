import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

jar.enabled = true
bootJar.enabled = false

dependencies {
    implementation(project(":bokeh-user-domain"))

    implementation("org.springframework.boot:spring-boot")

    implementation("org.mindrot:jbcrypt:0.4")
    implementation("io.jsonwebtoken:jjwt:0.9.1")
}
