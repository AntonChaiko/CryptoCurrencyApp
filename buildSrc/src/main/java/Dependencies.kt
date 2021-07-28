object Versions {
    const val kotlin = "1.5.21"


    const val compileSdkVersion = 30
    const val minSdkVersion = 23
    const val targetSdkVersion = 30
    const val applicationId = "com.example.cryptocurrency"
    const val applicationVersionCode = 1
    const val applicationVersionName = "1.0"

    // Android
    const val appcompat = "1.3.1"
    const val coreKtx = "1.6.0"

    // Testing
    const val junit = "4.13.2"
    const val testRunner = "1.1.3"
    const val espressoCore = "3.4.0"

    //UI
    const val material = "1.4.0"
    const val constraintLayout = "2.0.4"

    //LiveData
    const val lifecycle = "2.3.1"

    //Navigation
    const val navComponents = "2.3.5"

    //dagger
    const val dagger = "2.36"

    //koin
    const val koin = "3.1.2"

    //moshi
    const val moshi = "1.9.3"

    //retrofit
    const val retrofit = "2.9.0"
}

object Deps {

    // Kotlin
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"

    // Android
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"

    // Testing
    const val junit = "junit:junit:${Versions.junit}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"

    //UI
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    //lifecycle
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    //navigation
    const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navComponents}"
    const val navRuntime = "androidx.navigation:navigation-runtime:${Versions.navComponents}"
    const val navUi = "androidx.navigation:navigation-ui-ktx:${Versions.navComponents}"
    const val navDynamic =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navComponents}"

    //Dagger
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"

    //Koin
    const val koin = "io.insert-koin:koin-android:${Versions.koin}"

    //Retrofit
    const val retrofit = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    //Moshi
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"

}

object Kapt {
    //Dagger
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
}