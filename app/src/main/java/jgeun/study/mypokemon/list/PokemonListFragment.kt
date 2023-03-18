package jgeun.study.mypokemon.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import jgeun.study.mypokemon.databinding.FragmentPokemonListBinding

class PokemonListFragment : Fragment() {

	private lateinit var binding: FragmentPokemonListBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = FragmentPokemonListBinding.inflate(layoutInflater, container, false)
		return binding.root
	}

	companion object {
		@JvmStatic
		fun newInstance() = PokemonListFragment()
	}
}