package org.michaelbel.buildflavors

import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
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

    private var count: Int = 0

    fun reportAnalyticsEvent() {
        viewModelScope.launch {
            count++
            appInteractor.reportAnalyticsEvent("ButtonClicked", bundleOf("count" to count))
        }
    }
}