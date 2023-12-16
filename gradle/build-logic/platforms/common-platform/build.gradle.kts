plugins {
    id("java-platform")
}

group = "com.tomtresansky.surpriseme.buildlogic"

dependencies {
    constraints {
        api(libs.kotlin.stdlib)
        api(libs.log4j.core)
    }
}