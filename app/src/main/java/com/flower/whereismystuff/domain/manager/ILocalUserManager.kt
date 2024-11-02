package com.flower.whereismystuff.domain.manager

import kotlinx.coroutines.flow.Flow

interface ILocalUserManager {
    suspend fun saveAppEntry()

    fun readAppEntry(): Flow<Boolean>
}