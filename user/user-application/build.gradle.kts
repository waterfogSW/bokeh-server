import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

jar.enabled = true
bootJar.enabled = false

dependencies {
    implementation(project(":user-common"))
    implementation(project(":user-domain"))

    implementation("org.springframework.boot:spring-boot")
    implementation("org.mindrot:jbcrypt:0.4") // for password hashing
    implementation("com.auth0:java-jwt:4.4.0")
}
