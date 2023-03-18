package jgeun.study.mypokemon.type

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import jgeun.study.mypokemon.databinding.FragmentPokemonTypeBinding

class PokemonTypeFragment : Fragment() {

	private lateinit var binding: FragmentPokemonTypeBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = FragmentPokemonTypeBinding.inflate(layoutInflater, container, false)
		return binding.root
	}

	companion object {
		@JvmStatic
		fun newInstance() = PokemonTypeFragment()
	}
}