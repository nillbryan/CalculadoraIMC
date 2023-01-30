package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recuperar UI component no arquivo Kotlin (PEGAR O ID DO COMPONENTE no activity.xml)
        val bntCalcular: Button = findViewById(R.id.bntCalcular)
        val edtPeso: EditText = findViewById(R.id.editext_peso)
        val edtAltura: EditText = findViewById(R.id.editext_altura)


        // Colocar ação em um botão
        bntCalcular.setOnClickListener {

            // Aqui é o condigo do IMC
            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if(alturaStr.isNotEmpty() && pesoStr.isNotEmpty()){


            val altura: Float = alturaStr.toFloat()
            val peso: Float = pesoStr.toFloat()

            val alturaFinal: Float = altura * altura
            val imc: Float = peso / alturaFinal

            // Abrindo uma proxima tela com o resultado
            val intent = Intent(this, ResultActivity::class.java)
                .apply {
                    putExtra("EXTRA_RESULT", imc)
                }
            startActivity(intent)
            }else{
                Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show()
            }
        }

    }
}