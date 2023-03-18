package jgeun.study.mypokemon.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import jgeun.study.mypokemon.databinding.FragmentPokemonInfoBinding

class PokemonInfoFragment : Fragment() {

	private lateinit var binding: FragmentPokemonInfoBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = FragmentPokemonInfoBinding.inflate(layoutInflater, container, false)
		return binding.root
	}

	companion object {
		@JvmStatic
		fun newInstance() = PokemonInfoFragment()
	}
}