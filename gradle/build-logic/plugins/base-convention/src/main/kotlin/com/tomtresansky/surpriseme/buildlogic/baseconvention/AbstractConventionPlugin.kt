package com.tomtresansky.surpriseme.buildlogic.baseconvention

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jlleitschuh.gradle.ktlint.KtlintExtension

abstract class AbstractConventionPlugin : Plugin<Project> {
    fun Project.configureKtLint() {
        extensions.configure<KtlintExtension> {
            debug.set(true)
            verbose.set(true)

            filter {
                exclude {
                    it.file.path.contains("generated")
                }
            }
        }
    }
}
