package br.com.desafio.wccfinalchallenge.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.desafio.wccfinalchallenge.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun loginButton(component: View) {

        val login = Intent(this, Products::class.java)

        startActivity(login)
    }
}