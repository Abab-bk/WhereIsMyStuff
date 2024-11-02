package com.flower.whereismystuff.domain.usecases

import com.flower.whereismystuff.domain.manager.ILocalUserManager

class SaveAppEntry(
    private val localUserManager: ILocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}