package com.example.taller1movil.model

import kotlinx.serialization.Serializable


@Serializable
data class Producto(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val price: Double,
    val rating: Double,
    val thumbnail: String,
    val tags: List<String> = emptyList(),
    val dimensions: Dimensiones? = null,
    val reviews: List<Resena> = emptyList(),
    val images: List<String> = emptyList()
)

@Serializable
data class Dimensiones(val width: Double, val height: Double, val depth: Double)

@Serializable
data class Resena(val rating: Int, val comment: String, val reviewerName: String)