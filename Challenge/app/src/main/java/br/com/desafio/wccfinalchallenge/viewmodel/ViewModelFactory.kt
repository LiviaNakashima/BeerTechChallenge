package br.com.desafio.wccfinalchallenge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.desafio.wccfinalchallenge.repository.Repository

class ViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T :  ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelProduct::class.java)) {
            return ViewModelProduct(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModelProduct class")
    }
}