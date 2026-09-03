package com.example.taller1movil.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.taller1movil.model.Producto
import com.example.taller1movil.ui.components.TarjetaProductoComponente


@Composable
fun PantallaListaProductos(products: List<Producto>, onProductClick: (Producto) -> Unit) {
    val displayProducts = products.take(30)
    Log.d("APP_LOG", "Tamaño de productos: ${displayProducts.size}")

    Column(modifier = Modifier.fillMaxSize()) {

        Surface(shadowElevation = 4.dp, color = MaterialTheme.colorScheme.primaryContainer) {
            Text(
                text = "Total products: ${products.size}",
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                style = MaterialTheme.typography.titleMedium
            )
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(displayProducts) { product ->
                TarjetaProductoComponente(product, onProductClick)
            }
        }
    }
}