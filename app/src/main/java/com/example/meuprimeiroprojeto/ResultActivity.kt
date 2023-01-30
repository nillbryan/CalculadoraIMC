package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.texteview_result)
        val tvClassificacao = findViewById<TextView>(R.id.texteview_classificacao)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /*
        TABELA IMC

             IMC             CLASIFICAÇÃO        OBESIDADE (GRAU)

        MENOR QUE 18,5       MAGREZA                   0
        ENTRE 18,5 E 24,9    NORMAL                    0
        ENTRE 25,0 E 29,9    SOBREPESO                 I
        ENTRE 30,0 E 39,9    OBESIDADE                 II
        MAIOR QUE 40,0       OBESIDADE GRAVE           III
         */

        val clacificacao = if(result < 18.5){
            "ABIXO DO PESO GRAU 0"
        }else if(result in 18.5..24.9){
            "NORMAL GRAU 0"
        }else if(result in 25.0..29.9){
            "SOBREPESO GRAU I"
        }else if(result in 30.0..39.9){
            "OBESIDADE GRAU II"
        }else {
            "OBESIDADE GRAVE GRAU III"
        }

        tvClassificacao.text = getString(R.string.message_clacificacao, clacificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}