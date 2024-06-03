package com.example.testappsunil.di

import com.example.testappsunil.data.repository.ProductsRepoImpl
import com.example.testappsunil.domain.repository.ProductsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductsRepoModule {

    @Singleton
    @Binds
    abstract fun provideProductsRepo(repoImpl: ProductsRepoImpl): ProductsRepo

}