plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp) // Use KSP instead of kapt
}

android {
    namespace = "com.example.mvvmpractice"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.mvvmpractice"
        minSdk = 28
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isDebuggable = true
        }

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


    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // Dagger dependencies
    implementation(libs.dagger)
    ksp(libs.dagger.compiler)

//    implementation(libs.hilt.android)
    //ksp(libs.hilt.compiler)

    implementation(libs.androidx.activity.ktx)

    implementation(libs.viewmodel.ktx)
    implementation(libs.runtime.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
//    implementation(libs.android.arch.lifecycle)

    //glide & retrofit
    implementation(libs.glide)
    implementation(libs.retrofit2)
    implementation(libs.retrofit2.converter.gson)

    //room & coroutine
    implementation(libs.room.runtime)        // Room runtime
    implementation(libs.room.ktx)            // Kotlin extensions for Room
    //ksp(libs.room.compiler)                  // Room compiler with KSP
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

    //browser
    implementation(libs.androidx.browser)
}