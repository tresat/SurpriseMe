import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.tomtresansky.surpriseme.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

gradlePlugin{
    plugins{
        register("kotlin-multiplatform-project"){
            id="com.tomtresansky.surpriseme.kotlin-multiplatform-project"
            implementationClass="com.tomtresansky.surpriseme.buildlogic.KotlinMultiplatformProjectPlugin"
        }
    }
}
