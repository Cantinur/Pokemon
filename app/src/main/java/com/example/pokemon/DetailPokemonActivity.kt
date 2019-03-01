package com.example.pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail_pokemon.*

class DetailPokemonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pokemon)
        if (intent != null){
            val pokeName = intent.getStringExtra("poke_name") ?: "Pikachu"
            val imageID = resources.getIdentifier(pokeName.toLowerCase(), "drawable", packageName)
            pokemon_name.text = pokeName
            pokemon_image.setImageResource(imageID)
        }
    }
}
