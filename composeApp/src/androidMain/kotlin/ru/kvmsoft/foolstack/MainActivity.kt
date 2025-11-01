package ru.kvmsoft.foolstack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.kvmsoft.base.network.di.networkModule
import ru.kvmsoft.base.storage.datastore.di.storageModule
import ru.kvmsoft.base.utils.di.utilsModule
import ru.kvmsoft.features.authorization.imp.di.authorizationModule
import ru.kvmsoft.features.books.imp.di.booksModule
import ru.kvmsoft.features.events.imp.di.eventsModule
import ru.kvmsoft.features.interview.imp.di.interviewModule
import ru.kvmsoft.features.language.imp.di.languageModule
import ru.kvmsoft.features.language.imp.di.languagePlatformModule
import ru.kvmsoft.features.main.imp.di.mainModule
import ru.kvmsoft.features.networkconnection.imp.di.networkConnectionModule
import ru.kvmsoft.features.news.imp.di.newsModule
import ru.kvmsoft.features.professions.imp.di.professionsModule
import ru.kvmsoft.features.profile.imp.di.profileModule
import ru.kvmsoft.features.settings.imp.di.settingsModule
import ru.kvmsoft.features.splash.imp.di.splashModule
import ru.kvmsoft.features.tests.imp.di.testsModule

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        startKoin {
            // Provide the Android Context to Koin
            androidContext(this@MainActivity)
            androidLogger(Level.DEBUG) // Optional: for logging Koin activities
            modules(
                utilsModule,
                networkModule,
                storageModule,
                networkConnectionModule,
                languagePlatformModule, languageModule,
                splashModule,
                mainModule, authorizationModule, booksModule, eventsModule,
                interviewModule, splashModule,
                newsModule, professionsModule, profileModule, settingsModule, testsModule
            )
        }
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}