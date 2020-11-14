package br.com.desafio.wccfinalchallenge.api

import com.squareup.moshi.Json

data class Product(
    @Json(name= "desconto")
    val desconto: Boolean,
    @Json(name= "descricao")
    val descricao: String,
    @Json(name = "imagem")
    val imagem: String,
    @Json(name= "preco")
    val preco: Double,
    @Json(name = "produto")
    val produto: String
)


