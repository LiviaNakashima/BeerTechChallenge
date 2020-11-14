package br.com.desafio.wccfinalchallenge.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.desafio.wccfinalchallenge.entity.Product
import br.com.desafio.wccfinalchallenge.api.ProductApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ProductRepository {
    private val productListResponse = MutableLiveData<List<Product>>()

    val productsList: LiveData<List<Product>>
        get() = productListResponse

    init {
        getProducts()
    }

    private fun getProducts() {
        CoroutineScope(Dispatchers.IO).launch {
            try{
                val response = ProductApi.retrofitService.getProducts().body()
                productListResponse.postValue(response)
            } catch (e: Exception){
                withContext(Dispatchers.Main){
                    productListResponse.postValue(listOf())
                }
            }
        }
    }
}