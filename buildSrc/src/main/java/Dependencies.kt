object Versions {
    const val core = "1.9.0"
    const val appcompat = "1.5.1"
    const val androidMaterial = "1.6.1"
    const val constraintLayout = "2.1.4"
    const val testImplJunit = "4.13.2"
    const val androidTestImplJunit = "1.1.3"
    const val androidTestEspresso = "3.4.0"
    const val retrofit = "2.9.0"
    const val glide = "4.12.0"
    const val dagger = "2.44"
    const val hiltCompiler = "1.0.0"
    const val swipeRefresh = "1.1.0"
    const val kotlin = "1.3.21"
    const val retrofitGson = "2.9.0"
    const val gson = "2.8.8"
    const val coroutines = "1.6.0"
    const val lifecycle = "2.4.0"
    const val nav = "2.5.3"
    const val paging="3.1.1"
    const val shimmer="0.5.0"
    const val roomVersion = "2.4.3"
}

object Deps {

    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val androidMaterial = "com.google.android.material:material:${Versions.androidMaterial}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

}
object Modules{
    const val app = ":app"
    const val common = ":common"
    const val domain = ":domain"
    const val data = ":data"
}

object TestImplementation {

    const val junit = "junit:junit:${Versions.testImplJunit}"
}

object AndroidTestImplementation {

    const val junit = "androidx.test.ext:junit:${Versions.androidTestImplJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.androidTestEspresso}"

}
object Paging{
    const val runtime="androidx.paging:paging-runtime-ktx:${Versions.paging}"
    const val common="androidx.paging:paging-common-ktx:${Versions.paging}"
}

object Shimmer{
    const val shimmer="com.facebook.shimmer:shimmer:${Versions.shimmer}"
}


object Retrofit {
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"
}
object Room {
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val room = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val roomRuntime="androidx.room:room-runtime:${Versions.roomVersion}"
}


object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val annotationProcessor = "com.github.bumptech.glide:compiler:${Versions.glide}"
}
object DaggerHilt {
    const val hilt = "com.google.dagger:hilt-android:${Versions.dagger}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.dagger}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"
}


object CircularProgressBar {
    const val swipeRefresh =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefresh}"
}

object AndroidLibraries {
    // KOTLIN
    const val kotlinCoroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    // ANDROID
    const val lifeCycleViewModel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.lifecycle}"
    const val lifecycleViewModelExt = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"
    const val navigationFrag = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val livedata= "androidx.lifecycle:lifecycle-livedata-ktx:2.6.0"
    const val viewmodel ="androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0"

}
object KotlinLibraries {
    const val kotlinCoroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}


object BuildPlugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinJetBrains = "org.jetbrains.kotlin.android"
    const val kotlinKapt = "kotlin-kapt"
    const val Hilt = "com.google.dagger.hilt.android"
    const val DaggerHiltPlugin = "dagger.hilt.android.plugin"
    const val NavSafeArgs = "androidx.navigation.safeargs"
    const val NavSafeArgsKt = "androidx.navigation.safeargs.kotlin"
    const val AndroidLibrary = "com.android.library"
    const val ktlint = "org.jlleitschuh.gradle.ktlint"
    const val kotlinJvm = "org.jetbrains.kotlin.jvm"
}
