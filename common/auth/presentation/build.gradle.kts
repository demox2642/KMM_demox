plugins {
    id("multiplatform-setup")
    id("android-setup")
}
dependencies {
    implementation(project(mapOf("path" to ":common:core-compose")))
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":common:auth:api"))
                api(project(":common:core"))

                implementation(Dependencies.Other.ViewModel.core)
            }
        }
    }
}
