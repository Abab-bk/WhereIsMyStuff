package com.flower.whereismystuff.persention.onboarding

import com.flower.whereismystuff.R

data class Page(
    val title: Int,
    val description: Int,
    val onConfirm: () -> Unit = { }
)

val pages = listOf(
    Page(
        title = R.string.welcome_title,
        description = R.string.welcome_text
    ),
    Page(
        title = R.string.declare_title,
        description = R.string.declare_text,
    )
)
