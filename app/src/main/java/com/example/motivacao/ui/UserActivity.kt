package com.example.motivacao.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivacao.infra.MotivationConstantes
import com.example.motivacao.R
import com.example.motivacao.infra.SecurityPreferencees
import com.example.motivacao.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener(this)

        supportActionBar?.hide()

        verifyUserName()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_save) {
            handleSave()
        }
    }

    private fun verifyUserName(){
        val name =  SecurityPreferencees(this).getString(MotivationConstantes.Key.USER_NAME)
        if(name != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
    private fun handleSave() {
        val name = binding.editName.text.toString()
        if (name != "") {
            //salvando o nome do usuário
            SecurityPreferencees(this).storeString(MotivationConstantes.Key.USER_NAME, name)
            //Fazendo a navegação entre as activitys
            startActivity(Intent(this, MainActivity::class.java))
            //Destroi  a tela anterior
            //finish()

        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show()
        }
    }

}