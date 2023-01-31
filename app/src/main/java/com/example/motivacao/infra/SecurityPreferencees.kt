package com.example.motivacao.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferencees(context: Context) {
    private val security: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, str: String){
        //Código que salva o valor recebido
        security.edit().putString(key, str).apply()
    }

    fun getString(key: String) : String{
        //Caso eu passe um chave e não encontre ela, ele retorna o valor padrão que definimos, neste caso uma string vazia
        return security.getString(key, "") ?: ""
    }
}