plugins {
    `kotlin-dsl`
}

group = "com.tomtresansky.surpriseme.buildlogic"

dependencies {
    implementation(platform(projects.kotlinPlatform))

    implementation(projects.baseConvention)

    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)

    implementation(libs.commons.text)
}

gradlePlugin {
    plugins {
        register("kotlin-multiplatform-project") {
            id="com.tomtresansky.surpriseme.kotlin-multiplatform-project"
            implementationClass="com.tomtresansky.surpriseme.buildlogic.kotlinmultiplatform.KotlinMultiplatformProjectPlugin"
        }
    }
}
