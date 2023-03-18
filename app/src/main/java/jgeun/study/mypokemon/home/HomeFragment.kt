package jgeun.study.mypokemon.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import jgeun.study.mypokemon.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

	private lateinit var binding: FragmentHomeBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
		return binding.root
	}

	companion object {
		@JvmStatic
		fun newInstance() = HomeFragment()
	}
}