plugins {
    `java-library`
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.jetbrains.kotlin.jvm") version "1.9.0"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.9.0"
    id("org.jetbrains.kotlin.plugin.spring") version "1.9.0"
}

allprojects {
    group = "com.bokeh"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

    dependencies {
        testImplementation("io.mockk:mockk:1.13.7")
        testImplementation("io.kotest:kotest-runner-junit5:5.6.0")
        testImplementation("io.kotest:kotest-assertions-core:5.6.0")
        testImplementation("com.ninja-squad:springmockk:4.0.2")
        testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.3")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

}
