package br.com.desafio.wccfinalchallenge.api

import br.com.desafio.wccfinalchallenge.entity.Product

data class ProductResponseApi (
    val productsList: List<Product>
)