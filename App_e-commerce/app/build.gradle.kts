plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.app_e_commerce"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.app_e_commerce"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation("androidx.compose.material3:material3:1.1.2")
    implementation ("com.google.accompanist:accompanist-pager:0.31.3-beta")
    implementation ("com.google.accompanist:accompanist-pager-indicators:0.31.3-beta")
    implementation("androidx.compose.material:material-icons-extended-android:1.7.5")
    implementation("androidx.navigation:navigation-compose:2.8.4")
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("io.coil-kt:coil-compose:2.7.0")
    implementation ("com.google.accompanist:accompanist-pager:0.31.3-beta")
    implementation ("com.google.accompanist:accompanist-pager-indicators:0.31.3-beta")
    implementation ("androidx.compose.foundation:foundation:1.5.0")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui.test.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}