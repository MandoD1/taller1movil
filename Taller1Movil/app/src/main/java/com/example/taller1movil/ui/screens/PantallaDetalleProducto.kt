package com.example.taller1movil.ui.screens

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.taller1movil.model.Producto

@Composable
fun PantallaDetalleProducto(product: Producto) {
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        // Title -> ACTION_DIAL
        Text(
            text = product.title,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable {
                Log.d("APP_LOG", "Evento de intent: Se ha activado el intent de teléfono")
                val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${product.id}"))
                context.startActivity(dialIntent)
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = product.description,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.clickable {
                Log.d("APP_LOG", "Evento de intent: se ha activado un intent de SMS")
                val smsIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:")).apply {
                    putExtra("sms_body", "${product.title}: ${product.description}")
                }
                context.startActivity(smsIntent)
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Category: ${product.category}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Tags: ${product.tags.joinToString()}", style = MaterialTheme.typography.bodyMedium)

        product.dimensions?.let {
            Text(text = "Dimensions: ${it.width} x ${it.height} x ${it.depth}", style = MaterialTheme.typography.bodyMedium)
        }

        Text(text = "Reviews: ${product.reviews.size} reviews", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow {
            items(product.images) { imageUrl ->
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    modifier = Modifier.size(150.dp).padding(end = 8.dp)
                )
            }
        }
    }
}