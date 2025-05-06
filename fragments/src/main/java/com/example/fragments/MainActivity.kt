package com.example.fragments

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fragments.fragments.ChamadasFragments
import com.example.fragments.fragments.ConversarFraments

class MainActivity : AppCompatActivity() {
    private lateinit var btnMercado: Button
    private lateinit var btnChamadas: Button
    private lateinit var btnLimpar: Button
    var chamadas = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        /* // Begin transation
         val fragmentManager = supportFragmentManager.beginTransaction()

         // Add
         fragmentManager.add(R.id.fragmentContainerView, ConversarFraments())

         // Commit
         fragmentManager.commit()*/

        btnMercado = findViewById(R.id.btnMercado)
        btnChamadas = findViewById(R.id.btn_chamadas)
        btnLimpar = findViewById(R.id.btnLimpar)


        val chamadasFragments = ChamadasFragments()

        btnMercado.setOnClickListener {
            //Inicializa o fragment conversas
            val conversarFraments = ConversarFraments()

            // Cria o Bundle que o parametro que o Fragtment vai receber
            val bundle = bundleOf(
                "categoria" to "mercado"
            )
            //Passa O bundle através da função arguments
            conversarFraments.arguments = bundle
            chamadas = false
            // Forma otimizada
            supportFragmentManager
                .beginTransaction()
                //.add(R.id.fragment_conteudo, ConversarFraments())
                .replace(R.id.fragment_conteudo, conversarFraments)
                .commit()
        }
        btnChamadas.setOnClickListener {
            chamadas = true
            // Forma otimizada
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_conteudo, chamadasFragments)
                .commit()
        }
        /* btnLimpar.setOnClickListener {
           // Forma otimizada
            val fragmentManager = supportFragmentManager.beginTransaction()
            if (chamadas) {
                fragmentManager.remove(chamadasFragments)
            } else{
                fragmentManager.remove(conversarFraments)
            }
            // Commit
            fragmentManager.commit()
        }*/


    }
}