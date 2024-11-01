package com.flower.whereismystuff.persention.onboarding.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.flower.whereismystuff.persention.onboarding.Page

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = page.title),
            style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            text = stringResource(id = page.description),
            style = MaterialTheme.typography.displayMedium
        )
    }
}