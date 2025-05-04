package com.example.fragments

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fragments.fragments.ChamadasFragments
import com.example.fragments.fragments.ConversarFraments

class MainActivity : AppCompatActivity() {
    private lateinit var btnConversas: Button
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

        btnConversas = findViewById(R.id.btn_conversas)
        btnChamadas = findViewById(R.id.btn_chamadas)
        btnLimpar = findViewById(R.id.btnLimpar)

        val conversarFraments = ConversarFraments()
        val chamadasFragments = ChamadasFragments()

        btnConversas.setOnClickListener {
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
        btnLimpar.setOnClickListener {
            // Forma otimizada
            val fragmentManager = supportFragmentManager.beginTransaction()
            if (chamadas) {
                fragmentManager.remove(chamadasFragments)
            } else{
                fragmentManager.remove(conversarFraments)
            }
            // Commit
            fragmentManager.commit()
        }


    }
}