package com.example.fabregas_exer3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.fabregas_exer3.databinding.FragmentCongratulationBinding
import kotlinx.android.synthetic.main.fragment_congratulation.view.*

/**
 * A simple [Fragment] subclass.
 */
class CongratulationFragment : Fragment() {
    lateinit var binding: FragmentCongratulationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentCongratulationBinding>(inflater,R.layout.fragment_congratulation,container,false)
        binding.clicks.text = this.arguments?.get("clicks").toString()
        //we pass the name so that everytime the user goes back to the game fragment via restart button it doesnt get a null value
        binding.restart.setOnClickListener{
                view:View -> view.findNavController().navigate(R.id.action_congratulationFragment_to_gameFragment, bundleOf("player" to this.arguments?.get("name").toString()))      ;
        }
        return binding.root
    }

}
