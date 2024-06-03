package com.example.testappsunil.di

import android.content.Context
import androidx.room.Room
import com.example.testappsunil.db.ProductsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): ProductsDatabase {
        return Room.databaseBuilder(
            context, ProductsDatabase::class.java, ProductsDatabase.DB_NAME
        ).build()
    }

    @Provides
    fun provideDao(database: ProductsDatabase) = database.productsDao()
}