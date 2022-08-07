import org.gradle.api.artifacts.dsl.DependencyHandler

object ProjectDependencies {
    object Kotlin {
        const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
        const val MOSHI = "com.squareup.moshi:moshi:${Versions.MOSHI}"
    }

    object Euphony {
        const val EUPHONY = "euphony.lib:euphony:${Versions.EUPHONY}"
    }

    object Android {
        const val DESUGAR_LIBS = "com.android.tools:desugar_jdk_libs:${Versions.DESUGAR_LIBS}"
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
        const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"
        const val LIFECYCLE_KTX =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_KTX}"
        const val DATASTORE = "androidx.datastore:datastore-preferences:${Versions.DATASTORE}"
        const val ANDROIDX_APPCOMPAT = "androidx.appcompat:appcompat:${Versions.ANDROIDX_APPCOMPAT}"
        const val ANDROID_MATERIAL =
            "com.google.android.material:material:${Versions.ANDROID_MATERIAL}"
        const val NAVIGATION_FRAGMENT =
            "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
        const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
        const val NAVIGATION_COMPOSE =
            "androidx.navigation:navigation-compose:${Versions.NAVIGATION}"
    }

    object Compose {
        const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
        const val COMPOSE_MATERIAL =
            "androidx.compose.material:material:${Versions.COMPOSE_MATERIAL}"
        const val COMPOSE_MATERIAL3 =
            "androidx.compose.material3:material3:${Versions.COMPOSE_MATERIAL3}"
        const val COMPOSE_ACTIVITY =
            "androidx.activity:activity-compose:${Versions.COMPOSE_ACTIVITY}"
        const val COMPOSE_FOUNDATION =
            "androidx.compose.foundation:foundation:${Versions.COMPOSE_MATERIAL}"
        const val COMPOSE_ANIMATION =
            "androidx.compose.animation:animation:${Versions.COMPOSE_MATERIAL}"
        const val COMPOSE_UI_TOOL = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE_MATERIAL}"
        const val COMPOSE_UI_TOOL_PREVIEW =
            "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE_MATERIAL}"
        const val COMPOSE_VIEWMODEL =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.COMPOSE_LIFECYCLE_VIEWMODEL}"
        const val COMPOSE_RUNTIME_LIVEDATA =
            "androidx.compose.runtime:runtime-livedata:${Versions.COMPOSE_RUNTIME_LIVEDATA}"
    }

    object Test {
        const val CORE = "androidx.arch.core:core-testing:${Versions.CORE_TEST}"
        const val JUNIT = "junit:junit:${Versions.JUNIT}"
        const val JUNIT_JUPITER = "org.junit.jupiter:junit-jupiter-api:${Versions.JUNIT5}"
        const val JUNIT_PARAMS = "org.junit.jupiter:junit-jupiter-params:${Versions.JUNIT5}"
        const val JUNIT_ENGINE = "org.junit.jupiter:junit-jupiter-engine:${Versions.JUNIT5}"
        const val JUNIT_TRUTH = "com.google.truth:truth:${Versions.JUNIT5_TRUTH}"
        const val COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINE}"
        const val ANDROIDX_JUNIT = "androidx.test.ext:junit:${Versions.ANDROIDX_JUNIT}"
        const val ANDROIDX_ESPRESSO =
            "androidx.test.espresso:espresso-core:${Versions.ANDROIDX_ESPRESSO}"
    }

    fun DependencyHandler.common() {
        coreLibraryDesugaring(Android.DESUGAR_LIBS)
        implementation(Kotlin.KOTLIN)
        implementation(Kotlin.MOSHI)
        implementation(Euphony.EUPHONY)
        implementation(Android.CORE_KTX)
        implementation(Android.LIFECYCLE_KTX)
        implementation(Android.FRAGMENT_KTX)
        implementation(Android.DATASTORE)
        implementation(Android.ANDROIDX_APPCOMPAT)
        implementation(Android.ANDROID_MATERIAL)
        implementation(Android.NAVIGATION_FRAGMENT)
        implementation(Android.NAVIGATION_UI)
        implementation(Android.NAVIGATION_COMPOSE)
        implementation(Compose.COMPOSE_UI)
        implementation(Compose.COMPOSE_ACTIVITY)
        implementation(Compose.COMPOSE_FOUNDATION)
        implementation(Compose.COMPOSE_MATERIAL)
        implementation(Compose.COMPOSE_ANIMATION)
        implementation(Compose.COMPOSE_UI_TOOL)
        implementation(Compose.COMPOSE_UI_TOOL_PREVIEW)
        implementation(Compose.COMPOSE_VIEWMODEL)
        implementation(Compose.COMPOSE_MATERIAL3)
        implementation(Compose.COMPOSE_RUNTIME_LIVEDATA)
        implementation(Test.COROUTINE)
        implementation(Test.JUNIT)
        testImplementation(Test.CORE)
        testImplementation(Test.JUNIT_ENGINE)
        testImplementation(Test.JUNIT_JUPITER)
        testImplementation(Test.JUNIT_PARAMS)
        testImplementation(Test.JUNIT_TRUTH)
        androidTestImplementation(Test.ANDROIDX_JUNIT)
        androidTestImplementation(Test.ANDROIDX_ESPRESSO)
    }

    fun DependencyHandler.implementation(dependency: Any) {
        add("implementation", dependency)
    }

    fun DependencyHandler.kapt(dependency: String) {
        add("kapt", dependency)
    }

    fun DependencyHandler.testImplementation(dependency: String) {
        add("testImplementation", dependency)
    }

    fun DependencyHandler.androidTestImplementation(dependency: String) {
        add("androidTestImplementation", dependency)
    }

    fun DependencyHandler.testRuntimeOnly(dependency: String) {
        add("testRuntimeOnly", dependency)
    }

    fun DependencyHandler.coreLibraryDesugaring(dependency: String) {
        add("coreLibraryDesugaring", dependency)
    }
}
