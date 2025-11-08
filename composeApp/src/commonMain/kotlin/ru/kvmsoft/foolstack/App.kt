package ru.kvmsoft.foolstack

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject
import org.koin.dsl.KoinAppDeclaration
import ru.kvmsoft.base.navigation.NavigationApp
import ru.kvmsoft.base.network.di.networkModule
import ru.kvmsoft.base.storage.di.storageModule
import ru.kvmsoft.base.storage.di.storagePlatformModule
import ru.kvmsoft.base.utils.di.utilsModule
import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.features.authorization.imp.di.authorizationModule
import ru.kvmsoft.features.authorization.imp.di.authorizationPlatformModule
import ru.kvmsoft.features.books.imp.di.booksModule
import ru.kvmsoft.features.events.imp.di.eventsModule
import ru.kvmsoft.features.interview.imp.di.interviewModule
import ru.kvmsoft.features.language.api.domain.usecase.GetCurrentLanguageUseCase
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
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

@Composable
@Preview
//fun App(koinAppDeclaration: KoinAppDeclaration? = null, database: AppDatabase) {
fun App(koinAppDeclaration: KoinAppDeclaration? = null) {
    KoinApplication(application = {
        koinAppDeclaration?.invoke(this)
        modules(
            utilsModule,
            networkModule,
            storagePlatformModule,
            storageModule,
            networkConnectionModule,
            languagePlatformModule, languageModule,
            splashModule,
            mainModule,
            authorizationPlatformModule,
            authorizationModule,
            booksModule,
            eventsModule,
            interviewModule,
            splashModule,
            newsModule,
            professionsModule,
            profileModule,
            settingsModule,
            testsModule
        )
    }) {
        var langIsRus by remember { mutableStateOf(false) }
        val getCurrentLanguageUseCase = koinInject<GetCurrentLanguageUseCase>()
        LaunchedEffect(key1 = Unit) {
        getCurrentLanguageUseCase.getLang()
            getCurrentLanguageUseCase.langState.collect { state->
                if(state is ResultState.Success){
                    if(state.data == CurrentLanguageDomain.RU){
                        langIsRus = true
                    }
                }
            }
        }
        MaterialTheme{
            NavigationApp(langIsRus = langIsRus)
        }
    }
}