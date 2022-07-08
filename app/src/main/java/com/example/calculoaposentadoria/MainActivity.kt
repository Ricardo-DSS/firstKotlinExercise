package com.example.calculoaposentadoria

import android.app.Activity
import android.os.Bundle
import android.widget.*

class MainActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //definindo o arquivo de layout
        setContentView(R.layout.activity_main)

        //Instancia dos views do layout em variaveis
        val spn_sexo = findViewById<Spinner>(R.id.spn_sexo)
        val txt_idade = findViewById<EditText>(R.id.txt_idade)
        val btn_calcular = findViewById<Button>(R.id.btn_calcular)
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)

        //É necessário utilizar o seguinte código para configurar o spinner com items
        spn_sexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
            listOf("Masculino", "Feminino"))


        btn_calcular.setOnClickListener{
            //na variável abaixo será armazenado a opção do spinner escolhido pelo usuário
            val sexo = spn_sexo.selectedItem as String

            /*Como a propriedade abaixo é um EditText, isto significa que ele nos retorna um valor do
        * tipo editable, portanto é necessário convertê-lo em string e posteriormente em int para
        * realizar o cálculo */
            val idade = txt_idade.text.toString().toInt()

            var resultado = 0

            if (sexo == "Masculino") {
                resultado = 65 - idade
            } else {
                resultado = 60 - idade
            }

            txt_resultado.text = "Faltam ${resultado} anos para você se aposentar!"
        }
    }
}