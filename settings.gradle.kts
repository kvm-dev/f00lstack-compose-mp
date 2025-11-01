rootProject.name = "FoolStack"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")
include(":base:navigation")
include(":base:network")
include(":base:notifications")
include(":base:storage")
include(":base:ui")
include(":base:utils")
include(":base:viewmodel")
include(":features:asmode:api")
include(":features:asmode:imp")
include(":features:authorization:api")
include(":features:authorization:imp")
include(":features:books:api")
include(":features:books:imp")
include(":features:comments:api")
include(":features:comments:imp")
include(":features:events:api")
include(":features:events:imp")
include(":features:interview:api")
include(":features:interview:imp")
include(":features:language:api")
include(":features:language:imp")
include(":features:main:api")
include(":features:main:imp")
include(":features:networkconnection:api")
include(":features:networkconnection:imp")
include(":features:news:api")
include(":features:news:imp")
include(":features:professions:api")
include(":features:professions:imp")
include(":features:profile:api")
include(":features:profile:imp")
include(":features:registration:api")
include(":features:registration:imp")
include(":features:settings:api")
include(":features:settings:imp")
include(":features:splash:api")
include(":features:splash:imp")
include(":features:study:api")
include(":features:study:imp")
include(":features:tests:api")
include(":features:tests:imp")
