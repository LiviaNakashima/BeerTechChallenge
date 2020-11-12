package br.com.desafio.wccfinalchallenge.entity

data class Product(
        val id: Int,
        val produto: String,
        val descricao: String,
        val preco: Double,
        val desconto: Boolean,
        val imagem: String
)

