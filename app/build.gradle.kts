plugins {
    id("com.android.application") version "4.1.1"
    kotlin("android") version "1.4.10"
    kotlin("android.extensions") version "1.4.10"
}

android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.2")

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    defaultConfig {
        applicationId = "dev.patrickgold.florisboard"
        minSdkVersion(23)
        targetSdkVersion(29)
        versionCode(26)
        versionName("0.3.7")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        named("debug").configure {
            applicationIdSuffix = ".debug"
            resValue("string", "floris_app_name", "FlorisBoard Debug")
        }

        named("release").configure {
            isMinifyEnabled = false
            proguardFiles.add(getDefaultProguardFile("proguard-android-optimize.txt"))
            resValue("string", "floris_app_name", "@string/app_name")
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin", "kotlin-stdlib-jdk7")
    implementation("org.jetbrains.kotlin", "kotlin-reflect")
    implementation("androidx.appcompat", "appcompat", "1.2.0")
    implementation("androidx.core", "core-ktx", "1.3.2")
    implementation("androidx.preference", "preference-ktx", "1.1.1")
    implementation("androidx.constraintlayout", "constraintlayout", "2.0.4")
    testImplementation("junit", "junit", "4.12")
    testImplementation("androidx.test", "core", "1.3.0")
    testImplementation("org.mockito", "mockito-core", "1.10.19")
    testImplementation("org.mockito", "mockito-inline", "2.13.0")
    testImplementation("org.robolectric", "robolectric", "4.4")
    androidTestImplementation("androidx.test.ext", "junit", "1.1.2")
    androidTestImplementation("androidx.test.espresso", "espresso-core", "3.3.0")
    implementation("com.google.android", "flexbox", "2.0.1")
    implementation("com.squareup.moshi", "moshi-kotlin", "1.9.2")
    implementation("com.squareup.moshi", "moshi-adapters", "1.9.2")
    implementation("com.google.android.material", "material", "1.2.1")
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core", "1.3.7")
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-android", "1.3.7")
    implementation("com.jaredrummler", "colorpicker", "1.1.0")
    implementation("com.jakewharton.timber", "timber", "4.7.1")
    implementation("com.michael-bull.kotlin-result", "kotlin-result", "1.1.9")
    implementation("com.nambimobile.widgets", "expandable-fab", "1.0.2")
}
