package br.com.desafio.wccfinalchallenge.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.desafio.wccfinalchallenge.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun irProximaTela(component: View) {

        val telaLista = Intent(this, ProductActivity::class.java)

        startActivity(telaLista)
    }
}

