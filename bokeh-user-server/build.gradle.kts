plugins {
    `java-library`
    id(Plugins.SPRING_BOOT) version PluginVersion.SPRING_BOOT_VERSION
    id(Plugins.SPRING_DEPENDENCY_MANAGEMENT) version PluginVersion.SPRING_DEPENDENCY_MANAGEMENT_VERSION
    id(Plugins.KOTLIN_JVM) version PluginVersion.KOTLIN_VERSION
    id(Plugins.KOTLIN_JPA) version PluginVersion.KOTLIN_VERSION
    id(Plugins.KOTLIN_SPRING) version PluginVersion.KOTLIN_VERSION
}

allprojects {
    group = ProjectConfig.GROUP_NAME
    version = ProjectConfig.PROJECT_VERSION

    repositories {
        mavenCentral()
    }

    apply(plugin = Plugins.SPRING_BOOT)
    apply(plugin = Plugins.SPRING_DEPENDENCY_MANAGEMENT)
    apply(plugin = Plugins.KOTLIN_JVM)
    apply(plugin = Plugins.KOTLIN_JPA)
    apply(plugin = Plugins.KOTLIN_SPRING)

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
