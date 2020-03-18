package com.example.fabregas_exer3


import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.fabregas_exer3.databinding.FragmentTitleBinding
import kotlinx.android.synthetic.main.fragment_title.*

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {
    private lateinit var binding: FragmentTitleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,R.layout.fragment_title,container,false)

        binding.doneButton.setOnClickListener {
            view:View -> view.findNavController().navigate(R.id.action_titleFragment2_to_gameFragment,
            bundleOf("player" to binding.nameEntry.text.toString()))      ;
            addName()
        }
        return binding.root
    }

    private fun addName(){ //when the user clicks the done button it means that theyve inputted their name

        binding.apply{
            nameEntry.visibility = View.GONE
        }

    }

}
