import com.vmloft.develop.convention.VMDependencies

plugins {
    // 自定义配置插件，用来统一管理配置和依赖
    id("vm-publish")
}
android {
    namespace = "skin.support.constraint"
}

dependencies {
    implementation(VMDependencies.constraintLayout)
    implementation(project(":skin:skin-support"))
    implementation(project(":skin:skin-support-appcompat"))
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
//    implementation 'androidx.constraintlayout:constraintlayout:2.0.0-alpha2'
//    implementation project(':androidx:skin-support')
//    implementation project(':androidx:skin-support-appcompat')
//}
//
//ext {
//    publishVersion = rootProject.skinAndroidXVersion
//    publishGroup = rootProject.skinAndroidXSkinGroup
//    moduleName = 'skin-support-constraint-layout'
//    descContent = 'ConstraintLayout控件换肤支持包'
//}
//
//apply from: '../../publishing_maven.gradle'
