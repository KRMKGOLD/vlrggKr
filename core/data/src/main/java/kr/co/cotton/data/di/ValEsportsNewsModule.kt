package kr.co.cotton.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.cotton.data.sportsnews.datasource.RemoteValEsportsNewsDataSource
import kr.co.cotton.data.sportsnews.datasource.ValEsportsNewsDataSource
import kr.co.cotton.data.sportsnews.repository.DefaultValEsportsNewsRepository
import kr.co.cotton.data.sportsnews.repository.ValEsportsNewsRepository

@Module
@InstallIn(SingletonComponent::class)
interface ValEsportsNewsModule {

    @Binds
    fun bindsValEsportsNewsRepository(
        valEsportsNewsRepository: DefaultValEsportsNewsRepository
    ): ValEsportsNewsRepository

    @Binds
    fun bindValEsportsNewsDataSource(
        remoteValEsportsNewsDataSource: RemoteValEsportsNewsDataSource
    ): ValEsportsNewsDataSource
}