import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    id(Plugins.SPRING_BOOT) version PluginVersion.SPRING_BOOT_VERSION
    id(Plugins.SPRING_DEPENDENCY_MANAGEMENT) version PluginVersion.SPRING_DEPENDENCY_MANAGEMENT_VERSION
    id(Plugins.KOTLIN_JVM) version PluginVersion.KOTLIN_VERSION
    id(Plugins.KOTLIN_SPRING) version PluginVersion.KOTLIN_VERSION
}

java.sourceCompatibility = JavaVersion.VERSION_17

allprojects {
    group = ProjectConfig.GROUP_NAME
    version = ProjectConfig.PROJECT_VERSION

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    repositories {
        mavenCentral()
    }

    apply(plugin = Plugins.SPRING_BOOT)
    apply(plugin = Plugins.SPRING_DEPENDENCY_MANAGEMENT)
    apply(plugin = Plugins.KOTLIN_JVM)
    apply(plugin = Plugins.KOTLIN_SPRING)
}
