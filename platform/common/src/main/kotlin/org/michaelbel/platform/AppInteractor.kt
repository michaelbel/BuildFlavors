package org.michaelbel.platform

import android.os.Bundle
import kotlinx.coroutines.flow.Flow

interface AppInteractor {

    val flavorName: Flow<String>

    suspend fun reportAnalyticsEvent(name: String, params: Bundle)
}