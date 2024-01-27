plugins {
    `kotlin-dsl`
}

group = "com.tomtresansky.surpriseme.buildlogic"

dependencies {
    implementation(platform(projects.commonPlatform))
    api(projects.common)

    api(libs.kt.lint)
}