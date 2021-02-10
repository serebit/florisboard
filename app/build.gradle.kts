plugins {
    id("com.android.application") version "4.1.2"
    kotlin("android") version "1.4.30"
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
        freeCompilerArgs = listOf("-Xallow-result-return-type") // enables use of kotlin.Result
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
    implementation("androidx.appcompat", "appcompat", "1.2.0")
    implementation("androidx.core", "core-ktx", "1.3.2")
    implementation("androidx.preference", "preference-ktx", "1.1.1")
    implementation("androidx.constraintlayout", "constraintlayout", "2.0.4")
    implementation("com.google.android", "flexbox", "2.0.1") // requires jcenter as of version 2.0.1
    implementation("com.squareup.moshi", "moshi-kotlin", "1.11.0")
    implementation("com.squareup.moshi", "moshi-adapters", "1.11.0")
    implementation("com.google.android.material", "material", "1.3.0")
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-android", "1.4.2")
    implementation("com.jaredrummler", "colorpicker", "1.1.0")
    implementation("com.jakewharton.timber", "timber", "4.7.1")
    implementation("com.michael-bull.kotlin-result", "kotlin-result", "1.1.10")
    implementation("com.nambimobile.widgets", "expandable-fab", "1.0.2")

    testImplementation("junit", "junit", "4.13.1")
    testImplementation("org.mockito", "mockito-inline", "3.7.7")
    testImplementation("org.robolectric", "robolectric", "4.5.1")
    androidTestImplementation("androidx.test.ext", "junit", "1.1.2")
    androidTestImplementation("androidx.test.espresso", "espresso-core", "3.3.0")
}
