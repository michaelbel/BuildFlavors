package org.michaelbel.platform

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class AppInteractorImpl @Inject constructor(
    @param:ApplicationContext private val context: Context
): AppInteractor {

    override val flavorName: Flow<String> = flowOf("FOSS")

    override suspend fun reportAnalyticsEvent(name: String, params: Bundle) {
        Toast.makeText(context, "Не собирается", Toast.LENGTH_SHORT).show()
    }
}