package com.flower.whereismystuff.di

import android.app.Application
import com.flower.whereismystuff.data.manager.LocalUserManager
import com.flower.whereismystuff.domain.manager.ILocalUserManager
import com.flower.whereismystuff.domain.usecases.AppEntryUseCases
import com.flower.whereismystuff.domain.usecases.ReadAppEntry
import com.flower.whereismystuff.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): ILocalUserManager = LocalUserManager(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: ILocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

}