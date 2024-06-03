package com.example.testappsunil.di

import com.example.testappsunil.domain.repository.ProductsRepo
import com.example.testappsunil.domain.usecase.ProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ProductsUseCaseModule {

    @Provides
    fun provideProductsUseCase(repo: ProductsRepo) = ProductsUseCase(repo)

}