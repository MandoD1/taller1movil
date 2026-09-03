package com.example.taller1movil.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val EsquemaOscuro = darkColorScheme()

private val EsquemaClaro = lightColorScheme()

@Composable
fun TemaApp(
    oscuro: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val esquemaColores = if (oscuro) {
        EsquemaOscuro
    } else {
        EsquemaClaro
    }

    MaterialTheme(
        colorScheme = esquemaColores,
        content = content
    )
}