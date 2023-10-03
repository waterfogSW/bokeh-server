dependencies {
    implementation(project(":post-common"))
    implementation(project(":post-domain"))
    implementation(project(":post-application"))
    implementation(project(":post-adapter-mongo"))

    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-aop")

    developmentOnly("org.springframework.boot:spring-boot-devtools")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")
}
