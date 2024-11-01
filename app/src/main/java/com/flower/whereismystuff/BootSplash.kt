package com.flower.whereismystuff

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

enum class BootSplashPage {
    Welcome,
    DeclarePermission,
    End,
}

@Preview(showBackground = true)
@Composable
fun BootSplash() {
    var page by remember { mutableStateOf(BootSplashPage.Welcome) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                page = nextPage(page)
            }) {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "Next Button"
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)) {
            Page(page)
        }
    }
}

private fun nextPage(page: BootSplashPage): BootSplashPage {
    return when (page) {
        BootSplashPage.Welcome -> BootSplashPage.DeclarePermission
        BootSplashPage.DeclarePermission -> BootSplashPage.End
        BootSplashPage.End -> BootSplashPage.End
    }
}

@Composable
private fun Page(page: BootSplashPage) {
    when(page) {
        BootSplashPage.Welcome -> {
            Text(
                text = stringResource(id = R.string.welcome_info),
                modifier = Modifier.fillMaxWidth()
            )
        }
        BootSplashPage.DeclarePermission -> {
            Text(
                text = stringResource(id = R.string.declare_info),
                modifier = Modifier.fillMaxWidth()
            )
        }
        BootSplashPage.End -> {

        }
    }
}