enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        google()
        mavenCentral()
    }

    @Suppress("UnstableApiUsage")
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
}

includeBuild("gradle/build-logic")

rootProject.name = "SurpriseMe"

include(":androidApp")
include(":shared")

includeServerProject("datamodel")

fun includeServerProject(name: String) = includeProject(name, file("server"))

fun includeProject(name: String, subDir: File) {
    include(name)
    project(":$name").projectDir = File(subDir, name)
}