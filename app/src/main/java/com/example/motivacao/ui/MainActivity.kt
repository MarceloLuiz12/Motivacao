package com.example.motivacao.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivacao.infra.MotivationConstantes
import com.example.motivacao.R
import com.example.motivacao.infra.SecurityPreferencees
import com.example.motivacao.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var bindgin: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindgin = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindgin.root)

        //Esconder barra de navegação
        supportActionBar?.hide()

        handleUsername()
        bindgin.buttonNewPhrase.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_new_phrase){

        }
    }

    private fun handleUsername(){
        val name =  SecurityPreferencees(this).getString(MotivationConstantes.Key.USER_NAME)
        bindgin.textUserName.text = "Olá, $name!"
    }
}