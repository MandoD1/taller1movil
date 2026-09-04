package com.example.taller1movil.service

import com.example.taller1movil.model.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ServicioProducto {

    companion object {
        private var productosCache: List<Producto>? = null
    }

    suspend fun fetchProducts(): List<Producto> {
        if (productosCache != null) {
            return productosCache!!
        }

        return try {
            val response: RespuestaProductos = ClienteKtor.httpClient.get("https://dummyjson.com/products?limit=194").body()

            productosCache = response.products

            productosCache!!
        } catch (e: Exception) {
            emptyList()
        }
    }
}