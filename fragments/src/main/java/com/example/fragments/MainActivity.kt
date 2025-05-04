package com.example.fragments

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fragments.fragments.ConversarFraments

class MainActivity : AppCompatActivity() {
    private lateinit var btnConversas: Button
    private lateinit var btnChamadas: Button
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

        // Forma otimizada
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_conteudo, ConversarFraments())
            .commit()
    }
}