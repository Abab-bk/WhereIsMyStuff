package com.flower.whereismystuff.persention.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.flower.whereismystuff.R
import com.flower.whereismystuff.persention.onboarding.components.OnBoardingPage
import com.flower.whereismystuff.persention.onboarding.components.PageIndicator
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun OnBoardingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Constants.MediumPadding1
            )
    ) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }
        val buttonState = remember {
            derivedStateOf {
                when(pagerState.currentPage) {
                    0 -> listOf(R.string.empty, R.string.next_button)
                    1 -> listOf(R.string.back_button, R.string.next_button)
                    2 -> listOf(R.string.back_button, R.string.get_started)
                    else -> listOf()
                }
            }
        }

        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])
        }

        Spacer(modifier = Modifier.weight(1f))
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PageIndicator(
                modifier = Modifier.width(52.dp),
                pageSize = pages.size,
                selectedPage = pagerState.currentPage
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                val scope = rememberCoroutineScope()

                if (buttonState.value[0] != R.string.empty) {
                    Button(onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                        }
                    }) {
                        Text(text = stringResource(id = buttonState.value[0]))
                    }
                }

                Button(onClick = {
                    scope.launch {
                        if (pagerState.currentPage == pages.count()) {
                            // TODO: Navigation to main screen.
                        } else {
                            pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                        }
                    }
                }) {
                    Text(text = stringResource(id = buttonState.value[1]))
                }
            }
        }
    }
}