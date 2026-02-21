package ru.kvmsoft.features.main.imp.model

import ru.kvmsoft.base.utils.model.ResultState
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import ru.kvmsoft.features.profile.api.model.ProfileDomain

data class MainScreenData(
    val lang: ResultState<CurrentLanguageDomain>,
    val profile: ResultState<ProfileDomain>,
    val isKnowHowToUseSlider: Boolean
)
