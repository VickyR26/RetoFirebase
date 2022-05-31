package com.example.retofirebase

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.retofirebase.databinding.FragmentFormularioBinding
import com.example.retofirebase.databinding.FragmentVistaBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.json.JSONArray
import org.json.JSONObject


class VistaFragment : Fragment() {
    private lateinit var binding: FragmentVistaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVistaBinding.inflate(inflater, container, false)

        val database = Firebase.database
        val myRef = database.reference
        val navController = findNavController()

        myRef.child("Peliculas").get().addOnSuccessListener { response ->
            Log.d("firebaseResponse", response.value.toString())
            val peliculasArray = JSONArray(response.value.toString())
            binding.rvPeliculaEntries.adapter = MainAdapter(peliculasArray)
        }.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data")
        }

        binding.buttonRetorno.setOnClickListener{
            navController.navigate(R.id.action_vistaFragment_to_formularioFragment)
        }

        return binding.root

    }

}