package com.example.taller1movil.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.taller1movil.model.Producto

@Composable
fun TarjetaProductoComponente(product: Producto, onProductClick: (Producto) -> Unit) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onProductClick(product) }
            .padding(8.dp)
    ) {
        AsyncImage(
            model = product.thumbnail,
            contentDescription = product.title,
            modifier = Modifier
                .height(110.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = product.title)
        Text(text = product.category)
        Text(text = "$${product.price}")
        Text(text = "${product.rating}")
    }
}