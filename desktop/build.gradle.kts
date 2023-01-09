import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    jvm {
        withJava()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(project(":common:core-compose"))
                implementation(project(":common:core-utils"))
                implementation(project(":common:auth:compose"))
                implementation(project(":common:umbrella-core"))
                implementation(project(":common:umbrella-compose"))

                implementation(Dependencies.Other.Navigation.core)
                implementation(Dependencies.Other.Navigation.compose)
            }
        }

        named("jvmMain") {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "Main_desktopKt"

        nativeDistributions {
            targetFormats(
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb
            )
            packageName = "demox_bank"
            packageVersion = "1.0.0"

//            macOS {
//                iconFile.set(project.file("src/jvmMain/resources/icons/app_icon.icns"))
//            }
            windows {
                iconFile.set(project.file("src/jvmMain/resources/icons/app_icon.ico"))
            }
            linux {
                iconFile.set(project.file("src/jvmMain/resources/icons/app_icon.png"))
            }

            windows {
                menuGroup = "Demox BankKlient"
                // see https://wixtoolset.org/documentation/manual/v3/howtos/general/generate_guids.html
                upgradeUuid = "18159995-d967-4CD2-8885-77BFA97CFA9F"
            }
        }
    }
}