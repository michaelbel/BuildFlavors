package org.michaelbel.platform

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class AppInteractorImpl @Inject constructor(
    @param:ApplicationContext private val context: Context
): AppInteractor {

    override val flavorName: Flow<String> = flowOf("Google")

    override suspend fun reportAnalytics(name: String, params: Bundle) {
        val analytics = FirebaseAnalytics.getInstance(context)
        analytics.logEvent(name, params)

        Toast.makeText(context, "Отправлена в Google", Toast.LENGTH_SHORT).show()
    }
}