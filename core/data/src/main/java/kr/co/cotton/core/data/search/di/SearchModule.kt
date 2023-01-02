package kr.co.cotton.core.data.search.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.cotton.core.data.search.datasource.RemoteSearchDataSource
import kr.co.cotton.core.data.search.datasource.SearchDataSource
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ValSportsNewsModule {

    @Binds
    @Named("REMOTE")
    fun bindRemoteSearchDataSource(
        remoteSearchDataSource: RemoteSearchDataSource
    ): SearchDataSource
}