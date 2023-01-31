package com.example.motivacao.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.motivacao.infra.MotivationConstants
import com.example.motivacao.R
import com.example.motivacao.data.Mock
import com.example.motivacao.infra.SecurityPreferencees
import com.example.motivacao.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var bindgin: ActivityMainBinding
    private var categoryId =  1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindgin = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindgin.root)

        //Esconder barra de navegação
        supportActionBar?.hide()

        handleUsername()
        handleFilter(R.id.image_all)
        handleNextPhrase()

        bindgin.buttonNewPhrase.setOnClickListener(this)
        bindgin.imageAll.setOnClickListener(this)
        bindgin.imageHappy.setOnClickListener(this)
        bindgin.imageSunny.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_new_phrase){
            handleNextPhrase()
        }else if(view.id in listOf(R.id.image_all, R.id.image_happy, R.id.image_sunny)){
            handleFilter(view.id)
        }
    }

    private fun handleNextPhrase(){
        bindgin.textPhrase.text = Mock().getPhrase(categoryId)
    }

    private fun handleUsername(){
        val name =  SecurityPreferencees(this).getString(MotivationConstants.Key.USER_NAME)
        bindgin.textUserName.text = "Olá, $name!"
    }
    private fun handleFilter(id: Int){
        bindgin.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        bindgin.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        bindgin.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_all -> {
                categoryId = MotivationConstants.Filter.ALL
                bindgin.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
            }
            R.id.image_happy -> {
                categoryId = MotivationConstants.Filter.HAPPY
                bindgin.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
            }
            R.id.image_sunny -> {
                categoryId = MotivationConstants.Filter.SUNNY
                bindgin.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
            }
        }
    }
}