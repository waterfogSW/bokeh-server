import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

jar.enabled = true
bootJar.enabled = false

dependencies {
    implementation(project(":bokeh-user-domain"))

    // spring boot
    implementation("org.springframework.boot:spring-boot")

    // password encryption
    implementation("org.mindrot:jbcrypt:0.4")

    // jwt
    implementation("com.auth0:java-jwt:4.4.0")
}
