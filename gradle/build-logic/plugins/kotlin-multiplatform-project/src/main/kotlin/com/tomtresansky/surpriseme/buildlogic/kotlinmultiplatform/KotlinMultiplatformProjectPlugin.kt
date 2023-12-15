package com.tomtresansky.surpriseme.buildlogic.kotlinmultiplatform

import com.android.build.gradle.LibraryExtension
import com.tomtresansky.surpriseme.buildlogic.common.libs
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

abstract class KotlinMultiplatformProjectPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            val androidSdkVersion = libs().findVersion("androidSdkVersion").get().toString().toInt()
            val jvmVersion = libs().findVersion("jvmVersion").get().toString()

            with(pluginManager) {
                apply("org.jetbrains.kotlin.multiplatform")
                apply("com.android.library")
            }

            extensions.configure<LibraryExtension> {
                namespace = "com.tomtresansky.surpriseme.shared.${project.name}"
                compileSdk = androidSdkVersion

                defaultConfig {
                    minSdk = androidSdkVersion
                }
                compileOptions {
                    sourceCompatibility = JavaVersion.toVersion(jvmVersion)
                    targetCompatibility = JavaVersion.toVersion(jvmVersion)
                }
            }

            extensions.configure<KotlinMultiplatformExtension> {
                androidTarget {
                    compilations.all {
                        kotlinOptions {
                            jvmTarget = jvmVersion
                        }
                    }
                }
                iosX64()
                iosArm64()
                iosSimulatorArm64()
            }
        }
    }
}
