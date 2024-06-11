plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.gms.google-services")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.sbmshukla.glamora"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sbmshukla.glamora"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.database)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    val roomVersion = "2.6.1"
    val lifecycleVersion = "2.7.0"
    val coroutineVersion = "1.8.1-Beta"
    val navVersion = "2.7.7"
    val retrofitVersion = "2.9.0"
    val okHttpVersion = "4.12.0"
    val glideVersion = "4.16.0"
    val glideCompilerVersion = "4.16.0"
    val dotsIndicatorVersion = "5.0"
    val gsonCodeVersion = "2.9.1"
    val intuitVersion = "1.1.1"

// Room - A SQLite object mapping library for Android.
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")

// ViewModel - A part of the Android Architecture Components used to manage UI-related data in a lifecycle-conscious way.
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion")

// LiveData - An observable data holder class used to notify views when the underlying data changes.
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")

// Coroutines - For managing asynchronous programming and background tasks.
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion")

// Navigation - For managing navigation within the app.
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

// Retrofit - A type-safe HTTP client for Android and Java.
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")

// OKHttp - Used as an HTTP client for Retrofit with logging interceptor.
    implementation("com.squareup.okhttp3:okhttp:$okHttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okHttpVersion")

// Glide - An image loading and caching library for Android.
    implementation("com.github.bumptech.glide:glide:$glideVersion")
    kapt("com.github.bumptech.glide:compiler:$glideCompilerVersion")

    implementation("com.tbuonomo:dotsindicator:$dotsIndicatorVersion")
    implementation ("com.google.code.gson:gson:$gsonCodeVersion")

    //intuit - Size unit scales with the screen size (Helps developers with supporting multiple screens).
    implementation("com.intuit.sdp:sdp-android:$intuitVersion")   // https://github.com/intuit/sdp
    implementation("com.intuit.ssp:ssp-android:$intuitVersion")   // https://github.com/intuit/ssp
}