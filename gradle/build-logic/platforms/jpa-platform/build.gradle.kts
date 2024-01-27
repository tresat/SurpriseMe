plugins {
    id("java-platform")
}

group = "com.tomtresansky.surpriseme.buildlogic"

dependencies {
    constraints {
        api(libs.jakarta.persistence.api)
    }
}