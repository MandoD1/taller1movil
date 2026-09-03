package com.example.taller1movil.navigation

import androidx.compose.runtime.*
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.taller1movil.controller.ProductoViewModel
import com.example.taller1movil.ui.screens.PantallaDetalleProducto
import com.example.taller1movil.ui.screens.PantallaListaProductos


@Composable
fun NavegacionApp(viewModel: ProductoViewModel = viewModel()) {

    val productList by viewModel.productList.collectAsState()
    val backStack = remember { mutableStateListOf<RutaApp>(RutaApp.RutaLista) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { route ->
            when (route) {
                is RutaApp.RutaLista -> NavEntry(route) {
                    PantallaListaProductos(
                        products = productList,
                        onProductClick = { selectedProduct ->
                            backStack.add(RutaApp.RutaDetalle(selectedProduct))
                        }
                    )
                }
                is RutaApp.RutaDetalle -> NavEntry(route) {
                    PantallaDetalleProducto(product = route.product)
                }
            }
        }
    )
}