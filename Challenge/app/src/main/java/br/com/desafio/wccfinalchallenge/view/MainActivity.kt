package br.com.desafio.wccfinalchallenge.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import br.com.desafio.wccfinalchallenge.R
import br.com.desafio.wccfinalchallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val proximaTela = findViewById<Button>(R.id.bt_login)

        proximaTela.setOnClickListener {
            when {
                binding.etLogin.text.isEmpty() -> {
                    binding.etLogin.error = "O login não pode estar em branco"
                }
                binding.etSenha.text.isEmpty() -> {
                    binding.etSenha.error = "Digite sua senha"
                }
                else -> {
                    var intent = Intent(this, ProductActivity::class.java)

                    startActivity(intent)
                }
            }
        }
    }
}

