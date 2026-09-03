package com.example.taller1movil.model

import kotlinx.serialization.Serializable

@Serializable
data class RespuestaProductos(
    val products: List<Producto>
)