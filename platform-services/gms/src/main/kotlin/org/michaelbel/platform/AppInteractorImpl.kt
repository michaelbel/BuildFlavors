package org.michaelbel.platform

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class AppInteractorImpl @Inject constructor(): AppInteractor {

    override val flavorName: Flow<String> = flowOf("GOOGLE")

    override suspend fun reportAnalytics(name: String, params: Map<String, Any>) {
        // шлем аналитику в гугл
    }
}