package com.tomtresansky.surpriseme.buildlogic.common

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

fun Project.libs() = project.rootProject.extensions.getByType(VersionCatalogsExtension::class).named("libs")