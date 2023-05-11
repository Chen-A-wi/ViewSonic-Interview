buildscript {
    extra.apply {
        set("koin", "3.2.0")
        set("navigation", "2.5.1")
        set("junit", "5.8.2")
        set("lifecycle", "2.5.0-rc01")
        set("coroutines", "1.6.1")
        set("glide", "4.13.2")
    }
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("de.mannodermaus.gradle.plugins:android-junit5:1.8.2.0")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${rootProject.extra["navigation"]}")
    }
}

plugins {
    id("com.android.application") version "7.2.1" apply false
    id("com.android.library") version "7.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.7.10" apply false
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}