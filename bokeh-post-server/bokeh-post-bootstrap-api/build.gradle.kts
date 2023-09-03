apply(plugin = "kotlin-kapt")

dependencies {
    implementation(project(":bokeh-post-domain"))
    implementation(project(":bokeh-post-application"))
    implementation(project(":bokeh-post-framework"))

    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-aop")

    developmentOnly("org.springframework.boot:spring-boot-devtools")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")
}
