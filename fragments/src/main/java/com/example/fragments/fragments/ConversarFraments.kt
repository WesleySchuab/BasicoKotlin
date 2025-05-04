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
        btnExecutar = view.findViewById(R.id.btnExecutar)
        ediNome = view.findViewById(R.id.editNome)
        textNome = view.findViewById(R.id.textResultado)

        btnExecutar.setOnClickListener {
            textNome.text = ediNome.text.toString()
        }
        return view
    }
}