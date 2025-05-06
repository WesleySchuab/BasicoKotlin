package com.example.fragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragments.R

class ConversarFraments : Fragment() {
    private lateinit var btnExecutar: Button
    private lateinit var ediNome: EditText
    private lateinit var textNome: TextView
    private lateinit var textCategoria: TextView
    // Variavel criada para receber o argumento que será passado
    private var categoria : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Recupera as informações no oncreate antes do onCreateView
        // Que cria a visualização
        categoria = arguments?.getString("categoria")

    }

    //class ConversarFraments : Fragment (R.layout.fragments_conversas) {
    // Metodo que vai construir a visualização
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragments_conversas, container, false
        )
        // Processamento da visualização
        btnExecutar = view.findViewById(R.id.btn_executar)
        ediNome = view.findViewById(R.id.edit_nome)
        textNome = view.findViewById(R.id.textResultado)
        textCategoria = view.findViewById(R.id.text_categoria)

        textCategoria.text = categoria

        btnExecutar.setOnClickListener {
            textNome.text = ediNome.text.toString()
        }
        return view
    }
}