package com.example.fragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragments.R

class ChamadasFragments: Fragment () {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Passar o layout, viewgroup e booleano
        return inflater.inflate( R.layout.fragments_chamadas,
            container,
            false
        )
    }
}