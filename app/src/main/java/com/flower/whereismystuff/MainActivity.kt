package com.flower.whereismystuff

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.flower.whereismystuff.domain.usecases.AppEntryUseCases
import com.flower.whereismystuff.persention.onboarding.OnBoardingScreen
import com.flower.whereismystuff.persention.onboarding.OnBoardingViewModel
import com.flower.whereismystuff.ui.theme.WhereIsMyStuffTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var useCases: AppEntryUseCases

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        var toMainScreen = false

        lifecycleScope.launch {
            useCases.readAppEntry().collect {
                toMainScreen = it
                Log.d("test", "toMainScreen set: $toMainScreen")
            }
        }

        enableEdgeToEdge()

        setContent {
            WhereIsMyStuffTheme {
                if (toMainScreen) {
                    MainScreen()
                } else {
                    val viewModel: OnBoardingViewModel by viewModels()
                    OnBoardingScreen(viewModel::onEvent)
                }
            }
        }
    }
}