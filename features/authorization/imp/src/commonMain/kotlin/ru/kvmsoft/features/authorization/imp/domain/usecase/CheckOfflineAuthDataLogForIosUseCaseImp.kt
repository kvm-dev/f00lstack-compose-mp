package ru.kvmsoft.features.authorization.imp.domain.usecase

import ru.kvmsoft.features.authorization.api.domain.usecase.CheckOfflineAuthDataLogForIosUseCase
import ru.kvmsoft.features.authorization.imp.data.repository.AuthorizationRepository
import ru.kvmsoft.features.authorization.imp.platform

class CheckOfflineAuthDataLogForIosUseCaseImp(private val repository: AuthorizationRepository):
    CheckOfflineAuthDataLogForIosUseCase {
    override suspend fun checkIosAuthDataLog() {
        if(platform()=="iOS"){
            repository.checkAuthOfflineLogDataForIos()
        }
    }
}