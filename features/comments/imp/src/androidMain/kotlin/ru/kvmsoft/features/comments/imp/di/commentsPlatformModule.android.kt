package ru.kvmsoft.features.comments.imp.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.kvmsoft.features.comments.imp.data.network.DelayedCommentsSender
import ru.kvmsoft.features.comments.imp.data.repository.CommentsRepository

actual val commentsPlatformModule = module{
    single<DelayedCommentsSender> { DelayedCommentsSender(platformContext = androidContext()) }
    single<CommentsRepository> { CommentsRepository(localDataSource = get(), networkDataSource = get(), delayedCommentsSender = get()) }
}