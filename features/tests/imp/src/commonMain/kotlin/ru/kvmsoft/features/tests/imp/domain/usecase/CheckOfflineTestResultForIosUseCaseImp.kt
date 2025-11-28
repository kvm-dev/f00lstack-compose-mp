package ru.kvmsoft.features.tests.imp.domain.usecase

import ru.kvmsoft.features.tests.api.domain.usecase.CheckOfflineTestResultForIosUseCase
import ru.kvmsoft.features.tests.imp.data.repository.TestsRepository

class CheckOfflineTestResultForIosUseCaseImp(private val repository: TestsRepository): CheckOfflineTestResultForIosUseCase {
    override suspend fun checkResultIos() {
        repository.checkOfflineTestsResultDataForIos()
    }
}