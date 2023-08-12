import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

jar.enabled = true
bootJar.enabled = false

dependencies {
    implementation(project(":bokeh-user-domain"))
    implementation(project(":bokeh-user-application"))
    
    runtimeOnly("com.mysql:mysql-connector-j")
}
