package com.example.taller1movil.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.taller1movil.model.Producto
import com.example.taller1movil.ui.theme.TemaApp

@Composable
fun PantallaDetalleProducto(product: Producto) {
    val context = LocalContext.current
    var isDarkTheme by remember { mutableStateOf(false) }

    TemaApp(oscuro = isDarkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (isDarkTheme) "Dark" else "Light",
                        modifier = Modifier.padding(end = 8.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Switch(
                        checked = isDarkTheme,
                        onCheckedChange = { isDarkTheme = it }
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = product.title,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable {
                        val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${product.id}"))
                        context.startActivity(dialIntent)
                    }
                )
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.clickable {
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

                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Reviews:", style = MaterialTheme.typography.titleSmall)
                product.reviews.forEach { review ->
                    Text(
                        text = "- ${review.reviewerName} (${review.rating}): ${review.comment}",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(vertical = 2.dp)
                    )
                }

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
    }
}