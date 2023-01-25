package kr.co.cotton.core.data.sportsnews.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.cotton.core.data.sportsnews.datasource.LocalNewsDataSource
import kr.co.cotton.core.data.sportsnews.datasource.RemoteNewsDataSource
import kr.co.cotton.core.data.sportsnews.datasource.NewsDataSource
import kr.co.cotton.core.data.sportsnews.repository.DefaultNewsRepository
import kr.co.cotton.core.data.sportsnews.repository.NewsRepository
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NewsModule {

    @Binds
    fun bindsValEsportsNewsRepository(
        defaultNewsRepository: DefaultNewsRepository
    ): NewsRepository

    @Binds
    @Named("REMOTE")
    fun bindRemoteValEsportsNewsDataSource(
        remoteDataSource: RemoteNewsDataSource
    ): NewsDataSource

    @Binds
    @Named("LOCAL")
    @Singleton
    fun bindLocalValEsportsNewsDataSource(
        localNewsDataSource: LocalNewsDataSource
    ): NewsDataSource
}