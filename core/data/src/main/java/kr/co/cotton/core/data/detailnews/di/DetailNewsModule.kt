package kr.co.cotton.core.data.detailnews.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.cotton.core.data.detailnews.datasource.DetailNewsDataSource
import kr.co.cotton.core.data.detailnews.datasource.RemoteDetailNewsDataSource
import kr.co.cotton.core.data.detailnews.repository.DefaultDetailNewsRepository
import kr.co.cotton.core.data.detailnews.repository.DetailNewsRepository
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
interface DetailNewsModule {

    @Binds
    @Named("REMOTE")
    fun bindRemoteDetailNewsDataSource(
        remoteDetailNewsDataSource: RemoteDetailNewsDataSource
    ): DetailNewsDataSource

    @Binds
    fun bindDetailNewsRepository(
        detailNewsRepository: DefaultDetailNewsRepository
    ): DetailNewsRepository
}