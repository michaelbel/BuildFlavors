package org.michaelbel.platform

import kotlinx.coroutines.flow.Flow

interface AppInteractor {

    val flavorName: Flow<String>

    suspend fun reportAnalytics(name: String, params: Map<String, Any>)
}