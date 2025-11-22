package com.muhammad.skyflow.presentation.theme

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

val LightColorScheme = lightColorScheme(
    background = background,
    onBackground = onBackground
)

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SkyFlowTheme(content : @Composable () -> Unit) {
    MaterialExpressiveTheme(
        colorScheme = LightColorScheme,
        motionScheme = MotionScheme.expressive(),
        typography = Typography,
        content = content
    )
}