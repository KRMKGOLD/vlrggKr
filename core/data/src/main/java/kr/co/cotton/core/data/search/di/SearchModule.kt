package kr.co.cotton.core.data.search.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.cotton.core.data.search.datasource.RemoteSearchDataSource
import kr.co.cotton.core.data.search.datasource.SearchDataSource
import kr.co.cotton.core.data.search.repository.DefaultSearchRepository
import kr.co.cotton.core.data.search.repository.SearchRepository
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
interface SearchModule {

    @Binds
    @Named("REMOTE")
    fun bindRemoteSearchDataSource(
        remoteSearchDataSource: RemoteSearchDataSource
    ): SearchDataSource

    @Binds
    fun bindSearchRepository(
        searchRepository: DefaultSearchRepository
    ): SearchRepository
}