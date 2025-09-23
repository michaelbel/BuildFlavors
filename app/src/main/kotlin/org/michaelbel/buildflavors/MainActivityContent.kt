@file:OptIn(ExperimentalMaterial3Api::class)

package org.michaelbel.buildflavors

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MainActivityContent(
    viewModel: MainViewModel = hiltViewModel()
) {
    val flavorName by viewModel.flavorNameFlow.collectAsStateWithLifecycle()
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.app_name))
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Тип: $flavorName",
                fontSize = 34.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                lineHeight = 38.sp
            )

            Spacer(modifier = Modifier.height(36.dp))

            Button(
                onClick = { viewModel.reportAnalyticsEvent() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                contentPadding = ButtonDefaults.ContentPadding
            ) {
                Text(
                    text = "Кнопка с аналитикой",
                    fontSize = 18.sp
                )
            }
        }
    }
}