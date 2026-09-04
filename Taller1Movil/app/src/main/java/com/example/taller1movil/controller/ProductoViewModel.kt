package com.example.taller1movil.controller

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taller1movil.model.Producto
import com.example.taller1movil.service.ServicioProducto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductoViewModel : ViewModel() {
    private val service = ServicioProducto()
    private val _productList = MutableStateFlow<List<Producto>>(emptyList())
    val productList: StateFlow<List<Producto>> = _productList

    init {
        loadProducts()
    }

    private fun loadProducts() {
        viewModelScope.launch {
            _productList.value = service.fetchProducts()
        }
    }
}