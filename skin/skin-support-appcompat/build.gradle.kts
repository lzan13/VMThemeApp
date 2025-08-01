import com.vmloft.develop.convention.VMDependencies

plugins {
    // 自定义配置插件，用来统一管理配置和依赖
    id("vm-publish")
}
android {
    namespace = "skin.support.appcompat"
}

dependencies {
    implementation(VMDependencies.appCompat)
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
//    }
//    buildTypes {
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
//        }
//    }
//    sourceSets {
//        main {
//            res.srcDirs = ['src/main/res', 'src/main/res-alertdialog']
//        }
//    }
//}
//
//dependencies {
//    implementation fileTree(dir: 'libs', include: ['*.jar'])
//    implementation 'androidx.appcompat:appcompat:1.7.1'
//    implementation project(':androidx:skin-support')
//}
//
//tasks.withType(Javadoc) {
//    options.addStringOption('Xdoclint:none', '-quiet')
//    options.addStringOption('encoding', 'UTF-8')
//    options.addStringOption('charSet', 'UTF-8')
//}
//
//ext {
//    publishVersion = rootProject.skinAndroidXVersion
//    publishGroup = rootProject.skinAndroidXSkinGroup
//    moduleName = 'skin-support-appcompat'
//    descContent = 'skin-support 基础控件换肤支持包'
//}
//
//apply from: '../../publishing_maven.gradle'