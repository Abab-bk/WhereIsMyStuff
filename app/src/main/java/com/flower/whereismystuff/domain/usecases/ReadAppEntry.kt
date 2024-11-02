package com.flower.whereismystuff.domain.usecases

import com.flower.whereismystuff.domain.manager.ILocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: ILocalUserManager
) {
    suspend operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}