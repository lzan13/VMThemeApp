plugins {
    // 自定义配置插件，用来统一管理配置和依赖
    id("vm-publish")
}
android {
    namespace = "skin.support"
}

dependencies {

}
//apply plugin: 'com.android.library'
//
//android {
//    compileSdkVersion 30
//
//    defaultConfig {
//        minSdkVersion 14
//        targetSdkVersion 35
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
//}
//
//tasks.withType(Javadoc) {
//    options.addStringOption('Xdoclint:none', '-quiet')
//    options.addStringOption('encoding', 'UTF-8')
//    options.addStringOption('charSet', 'UTF-8')
//}
//
////ext {
////    publishVersion = rootProject.skinAndroidXVersion
////    publishGroup = rootProject.skinAndroidXSkinGroup
////    moduleName = 'skin-support'
////    descContent = 'skin-support core'
////}
////
////apply from: '../../publishing_maven.gradle'