plugins {
    id("com.android.application")
}

// Release signing is read from environment variables (set as GitHub secrets),
// so no key or password is ever stored in the repository.
val keystoreFile = System.getenv("YOLCHI_KEYSTORE_FILE")

android {
    namespace = "uz.yolchi.avtotest"
    compileSdk = 36

    defaultConfig {
        applicationId = "uz.yolchi.avtotest"
        minSdk = 26
        targetSdk = 36
        versionCode = (System.getenv("YOLCHI_VERSION_CODE") ?: "1").toInt()
        versionName = "1.0.0"
    }

    signingConfigs {
        if (keystoreFile != null) {
            create("release") {
                storeFile = file(keystoreFile)
                storePassword = System.getenv("YOLCHI_KEYSTORE_PASSWORD")
                keyAlias = System.getenv("YOLCHI_KEY_ALIAS")
                keyPassword = System.getenv("YOLCHI_KEY_PASSWORD")
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            if (keystoreFile != null) signingConfig = signingConfigs.getByName("release")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    androidResources {
        // keep mp3/woff2 uncompressed so the WebView can stream them
        noCompress += listOf("mp3", "woff2")
    }
}

dependencies {
    implementation("androidx.activity:activity:1.10.1")
    implementation("androidx.webkit:webkit:1.14.0")
}
