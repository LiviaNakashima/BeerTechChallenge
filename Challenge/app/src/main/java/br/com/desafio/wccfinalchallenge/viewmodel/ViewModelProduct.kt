package br.com.desafio.wccfinalchallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.desafio.wccfinalchallenge.entity.Product
import br.com.desafio.wccfinalchallenge.repository.Repository

class ViewModelProduct(private val repository: Repository): ViewModel() {
    val  productList: LiveData<List<Product>>
        get() = repository.productsList
}