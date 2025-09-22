package org.michaelbel.buildflavors

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.michaelbel.platform.AppInteractor
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appInteractor: AppInteractor
): ViewModel() {

    val flavorNameFlow: StateFlow<String> = appInteractor.flavorName
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = ""
        )

    fun reportAnalyticsEvent(count: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                appInteractor.reportAnalytics("ButtonClicked", mapOf("clicks" to count))
            }
        }
    }
}