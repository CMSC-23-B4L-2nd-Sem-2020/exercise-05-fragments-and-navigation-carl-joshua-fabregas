package com.example.fabregas_exer3


import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import com.example.fabregas_exer3.databinding.FragmentTitleBinding

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

        binding.doneButton.setOnClickListener { addName() }
        return binding.root
    }

    private fun addName(){ //when the user clicks the done button it means that theyve inputted their name

        binding.apply{
            nameEnt.text = nameEntry.text
            nameEntry.visibility = View.GONE
            nameEnt.visibility = View.VISIBLE
        }

    }

}
