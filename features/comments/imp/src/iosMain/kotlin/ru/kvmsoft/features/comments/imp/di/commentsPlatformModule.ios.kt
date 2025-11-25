package ru.kvmsoft.features.comments.imp.di

import org.koin.dsl.module
import ru.kvmsoft.features.comments.imp.data.repository.CommentsRepository

actual val commentsPlatformModule = module{
    single<CommentsRepository> { CommentsRepository(localDataSource = get(), networkDataSource = get()) }
}