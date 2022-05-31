package com.example.retofirebase

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.retofirebase.databinding.FragmentFormularioBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class FormularioFragment : Fragment() {
    private lateinit var binding: FragmentFormularioBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormularioBinding.inflate(inflater, container, false)

        val navController = findNavController()
        val database = Firebase.database
        val myRef = database.reference

        binding.buttonEnviar.setOnClickListener{
            val title = binding.editTextTitulo.text.toString()
            val year = binding.editTextYear.text.toString().toInt()
            val imdbID = binding.editTextId.text.toString()
            val type = binding.editTextTipo.text.toString()
            val poster = binding.editTextPoster.text.toString()
            val country = binding.editTextPais.text.toString()
            val genre = binding.editTextGenero.text.toString()

            myRef.child("Peliculas").child(imdbID).setValue (Peliculas(title, year, imdbID, type, poster, country, genre))

            navController.navigate(R.id.action_formularioFragment_to_vistaFragment)

        }

        binding.buttonVer.setOnClickListener {
            navController.navigate(R.id.action_formularioFragment_to_vistaFragment)
        }
        return binding.root
    }

}