package ru.kvmsoft.foolstack

import org.koin.core.context.startKoin
import ru.kvmsoft.base.network.di.networkModule
import ru.kvmsoft.base.storage.di.storageModule
import ru.kvmsoft.base.storage.di.storagePlatformModule
import ru.kvmsoft.base.utils.di.utilsModule
import ru.kvmsoft.features.asmode.imp.di.asModeModule
import ru.kvmsoft.features.authorization.imp.di.authorizationModule
import ru.kvmsoft.features.authorization.imp.di.authorizationPlatformModule
import ru.kvmsoft.features.books.imp.di.booksModule
import ru.kvmsoft.features.comments.imp.di.commentsModule
import ru.kvmsoft.features.comments.imp.di.commentsPlatformModule
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
import ru.kvmsoft.features.study.imp.di.studyModule
import ru.kvmsoft.features.tests.imp.di.testsModule
import ru.kvmsoft.features.tests.imp.di.testsPlatformModule
import androidx.compose.ui.window.ComposeUIViewController


fun MainViewController() = ComposeUIViewController(
    configure = {
        startKoin {
            modules(
                utilsModule,
                networkModule,
                storagePlatformModule,
                storageModule,
                networkConnectionModule,
                languagePlatformModule, languageModule,
                splashModule,
                asModeModule,
                mainModule,
                authorizationPlatformModule,
                authorizationModule,
                commentsPlatformModule,
                commentsModule,
                booksModule,
                eventsModule,
                interviewModule,
                splashModule,
                newsModule,
                professionsModule,
                profileModule,
                settingsModule,
                studyModule,
                testsPlatformModule,
                testsModule
            )
        }
    }
) {
    App()
}