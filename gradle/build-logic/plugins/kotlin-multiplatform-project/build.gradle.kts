plugins {
    `kotlin-dsl`
}

group = "com.tomtresansky.surpriseme.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)

    implementation(platform("com.tomtresansky.surpriseme.buildlogic:common-platform"))
    implementation(project(":common"))
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
