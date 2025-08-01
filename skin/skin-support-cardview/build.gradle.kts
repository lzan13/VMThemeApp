import com.vmloft.develop.convention.VMDependencies

plugins {
    // 自定义配置插件，用来统一管理配置和依赖
    id("vm-publish")
}
android {
    namespace = "skin.support.cardview"
}

dependencies {
//    implementation(VMDependencies.cardview)
    implementation("androidx.cardview:cardview:1.0.0")
    implementation(project(":skin:skin-support"))
}
//apply plugin: 'com.android.library'
//
//android {
//    compileSdkVersion rootProject.compileSdkVersion
//
//    defaultConfig {
//        minSdkVersion rootProject.minSdkVersion
//        targetSdkVersion rootProject.targetSdkVersion
//        versionCode 1
//        versionName "1.0"
//
//    }
//    buildTypes {
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
//        }
//    }
//}
//
//dependencies {
//    implementation fileTree(dir: 'libs', include: ['*.jar'])
//    implementation 'androidx.cardview:cardview:1.0.0'
//    implementation project(':androidx:skin-support')
//}
//
//ext {
//    publishVersion = rootProject.skinAndroidXVersion
//    publishGroup = rootProject.skinAndroidXSkinGroup
//    moduleName = "skin-support-cardview"
//    descContent = "CardView-v7 换肤支持包"
//}
//
//apply from: '../../publishing_maven.gradle'
