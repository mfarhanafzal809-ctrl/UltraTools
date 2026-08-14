plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.ultratools.app"

    compileSdk = 36

    defaultConfig {
        applicationId = "com.ultratools.app"

        minSdk = 26
        targetSdk = 36

        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"

            isMinifyEnabled = false
            isShrinkResources = false

            buildConfigField(
                "boolean",
                "PRODUCTION_BUILD",
                "false"
            )

            buildConfigField(
                "String",
                "ENVIRONMENT",
                "\"development\""
            )
        }

        release {
            isMinifyEnabled = true
            isShrinkResources = true

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            buildConfigField(
                "boolean",
                "PRODUCTION_BUILD",
                "true"
            )

            buildConfigField(
                "String",
                "ENVIRONMENT",
                "\"production\""
            )
        }
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    lint {
        abortOnError = true
        checkReleaseBuilds = true
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(
            org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
        )
    }
}

dependencies {

    implementation(libs.androidx.core)
    implementation(libs.androidx.core.splashscreen)

    implementation(libs.androidx.activity.compose)

    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    implementation(libs.androidx.navigation.compose)

    implementation(platform(libs.compose.bom))

    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)

    implementation(libs.compose.material3)
    implementation(libs.compose.material.icons)

    debugImplementation(libs.compose.ui.tooling)
}
