buildscript {
    dependencies {

    }
}
plugins {
    id(Plugins.ANDROID) version "1.5.31" apply false
    id(Plugins.LIBRARY) version "7.2.1" apply false
    id(Plugins.APPLICATION) version "7.2.1" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}