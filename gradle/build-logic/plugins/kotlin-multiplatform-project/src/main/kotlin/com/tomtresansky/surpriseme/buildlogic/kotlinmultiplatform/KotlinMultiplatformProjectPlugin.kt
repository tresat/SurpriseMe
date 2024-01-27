package com.tomtresansky.surpriseme.buildlogic.kotlinmultiplatform

import com.android.build.gradle.LibraryExtension
import com.tomtresansky.surpriseme.buildlogic.baseconvention.AbstractConventionPlugin
import com.tomtresansky.surpriseme.buildlogic.common.libs
import org.apache.commons.text.WordUtils
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.cocoapods.CocoapodsExtension

abstract class KotlinMultiplatformProjectPlugin : AbstractConventionPlugin() {
    override fun apply(project : Project) {
        with(project) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.multiplatform")
                apply("org.jetbrains.kotlin.native.cocoapods")
                apply("com.android.library")
                apply("org.jlleitschuh.gradle.ktlint")
            }

            val jvmVersion = libs().findVersion("jvmVersion").get().toString()

            extensions.configure<LibraryExtension> {
                val androidSdkVersion = libs().findVersion("androidSdkVersion").get().toString().toInt()

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

                jvm()

                iosX64()
                iosArm64()
                iosSimulatorArm64()

                sourceSets.commonMain.dependencies {
                    implementation(dependencies.platform("com.tomtresansky.surpriseme.buildlogic:common-platform"))

                    implementation(libs().findLibrary("kotlin-stdlib").get())
                }

                (this as ExtensionAware).extensions.configure<CocoapodsExtension> {
                    val capitalizedProjectName = WordUtils.capitalizeFully(project.name)

                    summary = "Some description for the $capitalizedProjectName Module"
                    homepage = "Link to the $capitalizedProjectName Module homepage"
                    version = "1.0"
                    ios.deploymentTarget = "16.0"
                    podfile = project.file("../iosApp/Podfile")
                    framework {
                        baseName = project.name
                        isStatic = true
                    }
                }
            }

            configureKtLint()
        }
    }
}
