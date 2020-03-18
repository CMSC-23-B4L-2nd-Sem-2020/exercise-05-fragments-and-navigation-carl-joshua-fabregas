package com.example.fabregas_exer3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.fabregas_exer3.databinding.FragmentCongratulationBinding

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

        return binding.root
    }

}
