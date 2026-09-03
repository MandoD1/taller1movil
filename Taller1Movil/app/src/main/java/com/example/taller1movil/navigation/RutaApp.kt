package com.example.taller1movil.navigation

import com.example.taller1movil.model.Producto
import kotlinx.serialization.Serializable


@Serializable
sealed class RutaApp {
    @Serializable data object RutaLista : RutaApp()
    @Serializable data class RutaDetalle(val product: Producto) : RutaApp()
}