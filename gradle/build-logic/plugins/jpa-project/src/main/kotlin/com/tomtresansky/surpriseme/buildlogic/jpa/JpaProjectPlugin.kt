package com.tomtresansky.surpriseme.buildlogic.jpa

import org.gradle.api.Plugin
import org.gradle.api.Project

abstract class JpaProjectPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            with(pluginManager) {
                apply("com.tomtresansky.surpriseme.kotlin-multiplatform-project")
            }
        }
    }
}
