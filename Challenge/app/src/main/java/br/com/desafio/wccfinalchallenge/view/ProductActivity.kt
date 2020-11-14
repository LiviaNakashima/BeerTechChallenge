package br.com.desafio.wccfinalchallenge.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.desafio.wccfinalchallenge.databinding.ActivityProductsBinding
import br.com.desafio.wccfinalchallenge.adapter.ProductAdapter
import br.com.desafio.wccfinalchallenge.repository.ProductRepository
import br.com.desafio.wccfinalchallenge.viewmodel.ProductViewModel
import br.com.desafio.wccfinalchallenge.viewmodel.ProductViewModelFactory

class ProductActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycleView = binding.recyclerView

        val adapter = ProductAdapter()
        recycleView.adapter = adapter

        val viewModelFactory = ProductViewModelFactory(ProductRepository())
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ProductViewModel::class.java)

        val itemsList = viewModel.productList
        itemsList.observe(this, Observer { items ->
            adapter.data = items
        })
    }
}