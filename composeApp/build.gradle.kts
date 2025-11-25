import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.sqldelight)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            //di
            implementation(libs.koin.android)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            //navigation
            implementation(projects.base.navigation)
            //asmode
            implementation(projects.features.asmode.imp)
            //screens
            implementation(projects.features.splash.imp)
            implementation(projects.features.main.imp)
            implementation(projects.features.authorization.imp)
            implementation(projects.features.books.imp)
            implementation(projects.features.events.imp)
            implementation(projects.features.interview.imp)
            implementation(projects.features.news.imp)
            implementation(projects.features.professions.imp)
            implementation(projects.features.profile.imp)
            implementation(projects.features.settings.imp)
            implementation(projects.features.study.imp)
            implementation(projects.features.tests.imp)
            //features
            implementation(projects.features.language.imp)
            implementation(projects.features.networkconnection.imp)
            implementation(projects.features.language.api)
            implementation(projects.features.language.imp)
            implementation(projects.features.comments.imp)
            //ui
            implementation(projects.base.ui)
            //di
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            //local encrypted storage and database
            implementation(projects.base.storage)
            //network
            implementation(projects.base.network)
            //utils
            implementation(projects.base.utils)

        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "ru.kvmsoft.foolstack"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "ru.kvmsoft.foolstack"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0.0"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}


dependencies {
    debugImplementation(compose.uiTooling)
}

