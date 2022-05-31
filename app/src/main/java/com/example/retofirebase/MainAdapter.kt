package com.example.retofirebase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retofirebase.databinding.PeliculaCardBinding
import org.json.JSONArray
import org.json.JSONObject

class MainAdapter (private val peliculas: JSONArray): RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val binding = PeliculaCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.render(peliculas[position] as JSONObject)
    }

    override fun getItemCount(): Int = peliculas.length()

    class MainHolder (val binding: PeliculaCardBinding): RecyclerView.ViewHolder(binding.root){
        fun render (peliculas: JSONObject){
            binding.TextId.setText(peliculas.getString("imdbID"))
            binding.TextTitulo.setText(peliculas.getString("title"))
            binding.TextPais.setText(peliculas.getString("country"))
            binding.TextTipo.setText(peliculas.getString("type"))
            binding.TextGenero.setText(peliculas.getString("genre"))
            binding.TextYear.setText(peliculas.getString("year"))
        }
    }

}