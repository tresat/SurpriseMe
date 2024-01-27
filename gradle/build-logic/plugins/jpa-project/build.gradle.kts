plugins {
    `kotlin-dsl`
}

group = "com.tomtresansky.surpriseme.buildlogic"

dependencies {
    implementation(platform(projects.commonPlatform))
    implementation(projects.common)

    implementation(projects.kotlinMultiplatformProject)
}

gradlePlugin {
    plugins {
        register("jpa-project") {
            id="com.tomtresansky.surpriseme.jpa-project"
            implementationClass="com.tomtresansky.surpriseme.buildlogic.jpa.JpaProjectPlugin"
        }
    }
}
