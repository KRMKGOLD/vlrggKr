package kr.co.cotton.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.cotton.core.data.sportsnews.datasource.LocalValEsportsNewsDataSource
import kr.co.cotton.core.data.sportsnews.datasource.RemoteValEsportsNewsDataSource
import kr.co.cotton.core.data.sportsnews.datasource.ValEsportsNewsDataSource
import kr.co.cotton.core.data.sportsnews.repository.DefaultValEsportsNewsRepository
import kr.co.cotton.core.data.sportsnews.repository.ValEsportsNewsRepository
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ValSportsNewsModule {

    @Binds
    fun bindsValEsportsNewsRepository(
        valEsportsNewsRepository: DefaultValEsportsNewsRepository
    ): ValEsportsNewsRepository

    @Binds
    @Named("REMOTE")
    fun bindRemoteValEsportsNewsDataSource(
        remoteValEsportsNewsDataSource: RemoteValEsportsNewsDataSource
    ): ValEsportsNewsDataSource

    @Binds
    @Named("LOCAL")
    @Singleton
    fun bindLocalValEsportsNewsDataSource(
        localValEsportsNewsDataSource: LocalValEsportsNewsDataSource
    ): ValEsportsNewsDataSource
}