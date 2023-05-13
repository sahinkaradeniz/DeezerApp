plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Deps.appCompat)
    implementation(Deps.core)
    testImplementation(TestImplementation.junit)

    implementation (DaggerHilt.hilt)
    kapt(DaggerHilt.hiltCompiler)
    kapt(DaggerHilt.hiltAndroidCompiler)

    implementation(Retrofit.retrofit)
    implementation(Retrofit.gson)
    implementation(Retrofit.retrofitGsonConverter)

    implementation(Room.room)
    kapt(Room.roomCompiler)
    annotationProcessor (Room.roomCompiler)
    implementation(Room.roomRuntime)

    implementation(project(Modules.domain))
    implementation(project(Modules.common))
}