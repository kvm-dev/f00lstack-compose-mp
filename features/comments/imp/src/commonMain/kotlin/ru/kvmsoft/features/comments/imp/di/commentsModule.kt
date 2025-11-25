package ru.kvmsoft.features.comments.imp.di

import org.koin.dsl.module
import ru.kvmsoft.features.comments.api.domain.usecase.SendMaterialCommentUseCase
import ru.kvmsoft.features.comments.imp.data.local.LocalDataSource
import ru.kvmsoft.features.comments.imp.data.network.CommentsApi
import ru.kvmsoft.features.comments.imp.data.network.NetworkDataSource
import ru.kvmsoft.features.comments.imp.domain.usecase.SendMaterialCommentUseCaseImp

val commentsModule = module {
    single<CommentsApi> { CommentsApi(client = get()) }
    single<NetworkDataSource> { NetworkDataSource(api = get()) }
    single<LocalDataSource> { LocalDataSource(dataBaseSDK = get()) }
    single<SendMaterialCommentUseCase> { SendMaterialCommentUseCaseImp(repository = get()) }
}