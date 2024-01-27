package com.tomtresansky.surpriseme.buildlogic.jpa

import com.tomtresansky.surpriseme.buildlogic.baseconvention.AbstractConventionPlugin
import org.gradle.api.Project
import com.tomtresansky.surpriseme.buildlogic.common.libs

abstract class JpaProjectPlugin : AbstractConventionPlugin() {
    override fun apply(project : Project) {
        with(project) {
            with(pluginManager) {
                apply("com.tomtresansky.surpriseme.kotlin-project")
                apply("org.jetbrains.kotlin.plugin.jpa")
            }

            with(dependencies) {
                add("implementation", libs().findLibrary("jakarta-persistence-api").get())
            }
        }
    }
}
