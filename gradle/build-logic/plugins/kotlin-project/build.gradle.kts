plugins {
    `kotlin-dsl`
}

group = "com.tomtresansky.surpriseme.buildlogic"

dependencies {
    implementation(platform(projects.kotlinPlatform))

    implementation(projects.baseConvention)
}

gradlePlugin {
    plugins {
        register("kotlin-project") {
            id="com.tomtresansky.surpriseme.kotlin-project"
            implementationClass="com.tomtresansky.surpriseme.buildlogic.kotlin.KotlinProjectPlugin"
        }
    }
}
