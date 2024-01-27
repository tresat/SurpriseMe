package com.tomtresansky.surpriseme.buildlogic.kotlin

import com.tomtresansky.surpriseme.buildlogic.baseconvention.AbstractConventionPlugin
import com.tomtresansky.surpriseme.buildlogic.common.libs
import org.gradle.api.Project

abstract class KotlinProjectPlugin : AbstractConventionPlugin() {
    override fun apply(project : Project) {
        with(project) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.jvm")
                apply("org.jlleitschuh.gradle.ktlint")
            }

            with(dependencies) {
                add("implementation", libs().findLibrary("kotlin-stdlib").get())
            }

            configureKtLint()
        }
    }
}
