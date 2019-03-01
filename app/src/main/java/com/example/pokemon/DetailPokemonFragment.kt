package com.example.pokemon


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_detail_pokemon.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class DetailPokemonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_pokemon, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val act = activity
        if (act?.intent != null){
            val pokeName = act.intent.getStringExtra("poke_name") ?: "Pikachu"
            val imageID = resources.getIdentifier(pokeName.toLowerCase(), "drawable", act.packageName)
            pokemon_name.text = pokeName
            pokemon_image.setImageResource(imageID)
        }
    }

    fun displayPokemon(pokeName: String){
        val imageID = resources.getIdentifier(pokeName.toLowerCase(), "drawable", activity!!.packageName)
        pokemon_name.text = pokeName
        pokemon_image.setImageResource(imageID)
    }

}
