plugins {
    `kotlin-dsl`
}

group = "com.tomtresansky.surpriseme.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)

    implementation(project(":common"))
}

gradlePlugin {
    plugins {
        register("kotlin-multiplatform-project") {
            id="com.tomtresansky.surpriseme.kotlin-multiplatform-project"
            implementationClass="com.tomtresansky.surpriseme.buildlogic.kotlinmultiplatform.KotlinMultiplatformProjectPlugin"
        }
    }
}
