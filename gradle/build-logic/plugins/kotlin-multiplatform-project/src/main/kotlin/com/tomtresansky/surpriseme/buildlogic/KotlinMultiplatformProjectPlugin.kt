package com.tomtresansky.surpriseme.buildlogic

import org.gradle.api.Plugin
import org.gradle.api.Project

abstract class KotlinMultiplatformProjectPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.multiplatform")
            }
        }
    }
}
