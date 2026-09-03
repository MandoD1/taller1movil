package com.example.taller1movil.service

import android.util.Log
import com.example.taller1movil.model.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ServicioProducto {
    suspend fun fetchProducts(): List<Producto> {
        return try {
            val response: RespuestaProductos = ClienteKtor.httpClient.get("https://dummyjson.com/products?limit=194").body()
            Log.d("APP_LOG", "Products size: ${response.products.size}")

            response.products
        } catch (e: Exception) {
            Log.e("APP_LOG", "Error fetching data: ${e.message}")
            emptyList()
        }
    }
}