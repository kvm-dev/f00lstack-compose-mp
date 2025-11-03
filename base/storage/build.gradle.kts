plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.androidLint)
    alias(libs.plugins.build.config)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.sqldelight)
}

kotlin {

    // Target declarations - add or remove as needed below. These define
    // which platforms this KMP module supports.
    // See: https://kotlinlang.org/docs/multiplatform-discover-project.html#targets
    androidLibrary {
        namespace = "ru.kvmsoft.base.storage"
        compileSdk = 36
        minSdk = 26

        withHostTestBuilder {
        }

        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    // For iOS targets, this is also where you should
    // configure native binary output. For more information, see:
    // https://kotlinlang.org/docs/multiplatform-build-native-binaries.html#build-xcframeworks

    // A step-by-step guide on how to include this library in an XCode
    // project can be found here:
    // https://developer.android.com/kotlin/multiplatform/migrate
    val xcfName = "base-storageKit"

    iosX64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosSimulatorArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    // Source set declarations.
    // Declaring a target automatically creates a source set with the same name. By default, the
    // Kotlin Gradle Plugin creates additional source sets that depend on each other, since it is
    // common to share sources between related targets.
    // See: https://kotlinlang.org/docs/multiplatform-hierarchy.html
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)
                //coroutines
                implementation(libs.kotlinx.coroutines.core)
                //di
                implementation(libs.koin.core)
                //database
                implementation(libs.sqldelight.coroutines.extension)
                //serialization
                implementation(libs.ktor.serialization.kotlinx.json)

            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
                //di
                implementation(libs.koin.test)
            }
        }

        androidMain {
            dependencies {
                //security
                implementation(libs.security.crypto)
                //data-store
                implementation(libs.datastore.preferences)
                //di
                implementation(libs.koin.android)
                implementation(libs.koin.compose)
                //database
                implementation(libs.sqldelight.android.driver)
            }
        }

        getByName("androidDeviceTest") {
            dependencies {
                implementation(libs.androidx.runner)
                implementation(libs.androidx.core)
                implementation(libs.androidx.testExt.junit)
            }
        }

        iosMain {
            dependencies {
                //database
                implementation(libs.sqldelight.native.driver)
            }
        }
    }
}

sqldelight {
    databases {
        create("AppDatabase") {
            packageName.set("ru.kvmsoft.base.storage")
        }
    }
}