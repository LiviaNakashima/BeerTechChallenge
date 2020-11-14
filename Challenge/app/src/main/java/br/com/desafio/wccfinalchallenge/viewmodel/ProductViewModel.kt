package br.com.desafio.wccfinalchallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.desafio.wccfinalchallenge.api.Product
import br.com.desafio.wccfinalchallenge.repository.ProductRepository

class ProductViewModel(private val repository: ProductRepository): ViewModel() {
    val  productList: LiveData<List<Product>>
        get() = repository.productsList
}