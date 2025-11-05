package ru.kvmsoft.features.profile.imp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.kvmsoft.features.profile.imp.domain.usecase.LogoutUseCaseImp
import ru.kvmsoft.features.profile.api.domain.usecase.DeleteProfileUseCase
import ru.kvmsoft.features.profile.api.domain.usecase.GetProfileUseCase
import ru.kvmsoft.features.profile.api.domain.usecase.LogoutUseCase
import ru.kvmsoft.features.profile.api.domain.usecase.UpdateEmailUseCase
import ru.kvmsoft.features.profile.api.domain.usecase.UpdateNameUseCase
import ru.kvmsoft.features.profile.api.domain.usecase.UpdatePhotoUseCase
import ru.kvmsoft.features.profile.imp.data.local.LocalDataSource
import ru.kvmsoft.features.profile.imp.data.network.NetworkDataSource
import ru.kvmsoft.features.profile.imp.data.network.ProfileApi
import ru.kvmsoft.features.profile.imp.data.repository.ProfileRepository
import ru.kvmsoft.features.profile.imp.domain.ProfileScreenInteractor
import ru.kvmsoft.features.profile.imp.domain.usecase.DeleteProfileUseCaseImp
import ru.kvmsoft.features.profile.imp.domain.usecase.GetProfileUseCaseImp
import ru.kvmsoft.features.profile.imp.domain.usecase.UpdateEmailUseCaseImp
import ru.kvmsoft.features.profile.imp.domain.usecase.UpdateNameUseCaseImp
import ru.kvmsoft.features.profile.imp.domain.usecase.UpdatePhotoUseCaseImp
import ru.kvmsoft.features.profile.imp.presentation.viewmodel.ProfileScreenViewModel

val profileModule = module {
    single<LocalDataSource> { LocalDataSource(databaseSdk = get(), encryptedDataStore = get()) }
    single<ProfileApi> { ProfileApi(client = get()) }
    single<NetworkDataSource> { NetworkDataSource(api = get()) }
    single<ProfileRepository> { ProfileRepository(
        localDataSource = get(),
        networkDataSource = get(),
        authorizationLocalDataSource = get(),
        authorizationNetworkDataSource = get()) }
    single<DeleteProfileUseCase> { DeleteProfileUseCaseImp(repository = get()) }
    single<GetProfileUseCase> { GetProfileUseCaseImp(repository = get()) }
    single<LogoutUseCase> { LogoutUseCaseImp(repository = get()) }
    single<UpdateEmailUseCase> { UpdateEmailUseCaseImp(repository = get()) }
    single<UpdateNameUseCase> { UpdateNameUseCaseImp(repository = get()) }
    single<UpdatePhotoUseCase> { UpdatePhotoUseCaseImp(repository = get()) }
    single<ProfileScreenInteractor> { ProfileScreenInteractor() }
    viewModelOf(::ProfileScreenViewModel)
}