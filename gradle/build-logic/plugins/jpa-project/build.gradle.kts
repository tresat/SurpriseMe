plugins {
    `kotlin-dsl`
}

group = "com.tomtresansky.surpriseme.buildlogic"

dependencies {
    implementation(platform(projects.jpaPlatform))

    implementation(projects.baseConvention)
    implementation(projects.kotlinProject)

    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.noarg)
}

gradlePlugin {
    plugins {
        register("jpa-project") {
            id="com.tomtresansky.surpriseme.jpa-project"
            implementationClass="com.tomtresansky.surpriseme.buildlogic.jpa.JpaProjectPlugin"
        }
    }
}
