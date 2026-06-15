package ru.kvmsoft.foolstack

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import ru.kvmsoft.base.navigation.NavigationApp
import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.features.language.api.domain.usecase.GetCurrentLanguageUseCase
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain


@Composable
@Preview
fun App() {
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