package com.example.pokemon


import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TableRow
import kotlinx.android.synthetic.main.fragment_pokedex.*

class PokedexFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokedex, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        for (i in 0 until table_layout.childCount){
            val row = table_layout.getChildAt(i) as TableRow
            for (j in 0 until row.childCount){
                val button = row.getChildAt(j) as ImageButton
                button.setOnClickListener{
                    pokemonClick(it)
                }
            }
        }
    }

    fun pokemonClick(view: View){
        val button = view as ImageButton
        val tag = button.tag.toString()

        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            val intent = Intent(activity, DetailPokemonActivity::class.java)
            intent.putExtra("poke_name", tag)
            startActivity(intent)
        } else {
            val detailsFragment = fragmentManager?.findFragmentById(R.id.horizontal_details_fragment) as DetailPokemonFragment
            detailsFragment.displayPokemon(tag)
        }
    }
}
