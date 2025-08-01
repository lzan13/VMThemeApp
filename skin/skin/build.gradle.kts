plugins {
    // 自定义配置插件，用来统一管理配置和依赖
    id("vm-skin")
}
android {
    namespace = "com.vmloft.develop.app.skin"


    // 多渠道配置
    flavorDimensions += "skin"
    productFlavors {
        create("basil") {
            dimension = "skin"
            applicationIdSuffix = ".basil"
        }
        create("blue") {
            dimension = "skin"
            applicationIdSuffix = ".blue"
        }
//        create("cosmopolitan") {
//            dimension = "skin"
//            applicationIdSuffix = ".cosmopolitan"
//        }
    }
}

dependencies {

}
//plugins {
//    id("com.android.application")
//    id("org.jetbrains.kotlin.android")
//}
//
//android {
//    namespace = "com.vmloft.develop.app.skin"
//    compileSdk = 35
//
//    defaultConfig {
//        applicationId = "com.vmloft.develop.app.skin"
//        minSdk = 24
//        targetSdk = 35
//        versionCode = 1
//        versionName = "1.0"
//
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//    }
//
//    buildTypes {
//        release {
//            isMinifyEnabled = false
//            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
//        }
//    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_11
//        targetCompatibility = JavaVersion.VERSION_11
//    }
//    kotlinOptions {
//        jvmTarget = JavaVersion.VERSION_11.toString()
//    }
//    // 多渠道配置
//    flavorDimensions += "defalut"
//
//    productFlavors {
//        create("defalut") {
//        }
//
//        create("gold") {
//            applicationIdSuffix = ".gold"
//        }
//
//        create("blue") {
//            applicationIdSuffix = ".blue"
//        }
//    }
//
//}
//
//dependencies {
//
//}