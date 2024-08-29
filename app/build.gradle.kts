plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "uk.ac.bbk.bfit"
    compileSdk = 34

    defaultConfig {
        applicationId = "uk.ac.bbk.bfit"
        minSdk = 28
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    androidTestImplementation(libs.espresso.core)

    // Room dependency
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-compiler:2.6.1")

    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.0")

}