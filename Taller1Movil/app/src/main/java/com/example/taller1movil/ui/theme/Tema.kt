package com.example.taller1movil.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val RojoPrincipal = Color(0xFFD32F2F)
private val RojoModoOscuro = Color(0xFFEF5350)
private val Blanco = Color(0xFFFFFFFF)
private val Negro = Color(0xFF121212)
private val SuperficieOscura = Color(0xFF1E1E1E)

private val EsquemaClaro = lightColorScheme(
    primary = RojoPrincipal,
    onPrimary = Blanco,
    primaryContainer = Color(0xFFD32F2F),
    onPrimaryContainer = Color(0xFFFFCDD2),
    background = Blanco,
    onBackground = Color(0xFF1C1B1F),
    surface = Blanco,
    onSurface = Color(0xFF1C1B1F)
)

private val EsquemaOscuro = darkColorScheme(
    primary = RojoModoOscuro,
    onPrimary = Negro,
    primaryContainer = Color(0xFFB71C1C),
    onPrimaryContainer = Color(0xFFFFCDD2),
    background = Negro,
    onBackground = Blanco,
    surface = SuperficieOscura,
    onSurface = Blanco
)

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