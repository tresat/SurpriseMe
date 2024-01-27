pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()

        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    @Suppress("UnstableApiUsage")
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    versionCatalogs {
        create("libs") {
            from(files("../../gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "build-logic"

include(":common")

includePlatformProject("common-platform")
includePlatformProject("kotlin-platform")
includePlatformProject("jpa-platform")

includePluginProject("base-convention")
includePluginProject("kotlin-project")
includePluginProject("jpa-project")
includePluginProject("kotlin-multiplatform-project")

fun includePluginProject(name: String) = includeProject(name, file("plugins"))
fun includePlatformProject(name: String) = includeProject(name, file("platforms"))

fun includeProject(name: String, subDir: File) {
    include(name)
    project(":$name").projectDir = File(subDir, name)
}
