package br.com.desafio.wccfinalchallenge.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.desafio.wccfinalchallenge.databinding.ActivityProductsBinding
import br.com.desafio.wccfinalchallenge.adapter.Adapter
import br.com.desafio.wccfinalchallenge.databinding.ProductItemBinding
import br.com.desafio.wccfinalchallenge.repository.Repository
import br.com.desafio.wccfinalchallenge.viewmodel.ViewModelProduct
import br.com.desafio.wccfinalchallenge.viewmodel.ViewModelFactory

class ProductActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycleView = binding.recyclerView

        val adapter = Adapter()
        recycleView.adapter = adapter

        val viewModelFactory = ViewModelFactory(Repository())
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ViewModelProduct::class.java)

        val itemsList = viewModel.productList
        itemsList.observe(this, Observer { items ->
            adapter.data = items
        })
    }
}