package kr.co.cotton.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.cotton.data.datasource.RemoteValEsportsNewsDataSource
import kr.co.cotton.data.datasource.ValEsportsNewsDataSource
import kr.co.cotton.data.repository.DefaultValEsportsNewsRepository
import kr.co.cotton.data.repository.ValEsportsNewsRepository

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