import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.jetbrains.kotlin.gradle.plugin.extraProperties

plugins {
    // These plugins must be defined at root project, to get the same version throughout and
    // avoid "The Kotlin Gradle plugin was loaded multiple times in different subprojects, which is not supported and may break the build."
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.kotlinCocoapods).apply(false)

    // Actual top-level plugins
    alias(libs.plugins.affectedModuleDetector)
    alias(libs.plugins.versions)
    alias(libs.plugins.dependencyAnalysis)
    alias(libs.plugins.moduleDependencyGraph)
}

description = """Creates fuzzy alerts that are a welcome surprise!"""
defaultTasks("build")

val checkAll = tasks.register("checkAll") {
    group = LifecycleBasePlugin.VERIFICATION_GROUP
    description = "Runs all checks and maintenance reports"

    dependsOn(tasks.findByName("dependencyUpdates"))
    dependsOn(tasks.findByName("buildHealth"))
    dependsOn(tasks.findByName("graphModules"))
}

subprojects {
    checkAll.configure {
        dependsOn(tasks.withType(Test::class))
    }
}

// Automatically accept build scan TOS
if (hasProperty("buildScan")) {
    extensions.findByName("buildScan")?.withGroovyBuilder {
        setProperty("termsOfServiceUrl", "https://gradle.com/terms-of-service")
        setProperty("termsOfServiceAgree", "yes")
    }
}

// Configure what types of updates should be flagged by the versions plugin
fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.uppercase().contains(it) }
    val basicRegex = "[0-9,.v-]+(-r)?"
    val groovyVersionsRegex = "$basicRegex-jre"
    val guavaJreVersionsRegex = "$basicRegex-groovy-$basicRegex"
    val regex = "^(${basicRegex})|(${groovyVersionsRegex})|(${guavaJreVersionsRegex})".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        // We don't want non-stable versions, and need to stick with the launcher version Gradle knows
        isNonStable(candidate.version) || candidate.module == "junit-platform-launcher"
    }

    filterConfigurations = Spec<Configuration> { false }

    revision="release"

    gradleReleaseChannel="release-candidate"
    checkConstraints = true
    checkBuildEnvironmentConstraints = true

    outputFormatter="json,html"
    outputDir = layout.buildDirectory.dir("reports/dependency-updates").get().asFile.path
}


// Configure Module dependency graph plugin to output to build/reports
tasks.named("graphModules") {
    project.extraProperties.let { properties ->
        properties.set("autoOpenGraph", "false")

        val moduleDependenciesReportsDir = project.layout.buildDirectory.dir("reports/module-dependencies").get()
        moduleDependenciesReportsDir.asFile.mkdirs()
        properties.set("dotFilePath", moduleDependenciesReportsDir.file("dependency-graph.dot"))
        properties.set("graphOutputFilePath", moduleDependenciesReportsDir.file("dependency-graph.png"))
    }
}
