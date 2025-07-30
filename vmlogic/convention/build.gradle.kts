plugins {
    `kotlin-dsl`
}

// 配置 Java 编译版本
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
//kotlin{
//    jvmToolchain(17)
//}

// 添加插件依赖
dependencies {
    implementation("com.android.tools.build:gradle:8.8.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0")
}

// 注册插件
gradlePlugin {
    // 声明插件信息，
    plugins {
        // 这里的 register 参数可随意填写，主要应用在 id
        register("vm-app") {
            id = "vm-app"
            implementationClass = "com.vmloft.develop.convention.plugin.VMApp"
        }
        // Library 插件
        register("vm-library") {
            id = "vm-library"
            implementationClass = "com.vmloft.develop.convention.plugin.VMLibrary"
        }
        register("vm-l-common") {
            id = "vm-l-common"
            implementationClass = "com.vmloft.develop.convention.plugin.VMLCommon"
        }
        register("vm-l-image") {
            id = "vm-l-image"
            implementationClass = "com.vmloft.develop.convention.plugin.VMLImage"
        }
        register("vm-l-request") {
            id = "vm-l-request"
            implementationClass = "com.vmloft.develop.convention.plugin.VMLRequest"
        }
        // 发布插件
        register("vm-publish") {
            id = "vm-publish"
            implementationClass = "com.vmloft.develop.convention.plugin.VMPublish"
        }
    }
}
