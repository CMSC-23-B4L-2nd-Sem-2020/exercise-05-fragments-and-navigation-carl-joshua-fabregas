package com.example.fabregas_exer3

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.fabregas_exer3.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater,R.layout.fragment_game,container,false)

        var array = createArray()

        binding.retry.setOnClickListener { retry(array) }
        run(array,binding.retry)

        return binding.root
    }

    private fun checker(view:List<List<Button>> , i: Int, j: Int, butts: Button){ //checkered referring to checking the side  of the clicked button
        //if the retry button is visible
        if(butts.visibility == View.GONE){
            butts.visibility = View.VISIBLE
        }

        //clicks the button
        is_white(view[i][j])
        if(i==0 && j==0){
            is_white(view[i+1][j])
            is_white(view[i][j+1])
        }else if (i==0 && j==4){
            is_white(view[i][j-1])
            is_white(view[i+1][j])
        }else if(i == 4 && j == 0){
            is_white(view[i-1][j])
            is_white(view[i][j+1])
        }else if(i==4 && j == 4){
            is_white(view[i][j-1])
            is_white(view[i-1][j])
        }else if(i==0 && j!=0 && j!=4){
            is_white(view[i][j-1])
            is_white(view[i][j+1])
            is_white(view[i+1][j])
        }else if(i!=0 && i!= 4 && j==0){
            is_white(view[i+1][j])
            is_white(view[i-1][j])
            is_white(view[i][j+1])
        }else if(i==4 && j!= 4 && j!=0){
            is_white(view[i-1][j])
            is_white(view[i][j+1])
            is_white(view[i][j-1])
        }else if (i!=4 && i!=0 && j==4){
            is_white(view[i][j-1])
            is_white(view[i-1][j])
            is_white(view[i+1][j])
        }else{
            is_white(view[i][j-1])
            is_white(view[i][j+1])
            is_white(view[i+1][j])
            is_white(view[i-1][j])
        }
    }

    private fun is_white(view:Button){ //checks using the set tag intially 0, when the tag is 1, it changes the color

        if(view.getTag() == 1){
            view.setBackgroundColor(Color.parseColor("Teal"))
            view.setTag(0)
        }else{
            view.setBackgroundColor(Color.CYAN)
            view.setTag(1)
        }

    }

    private fun run(view: List<List<Button>>, butts: Button){ //the whole game process
        for (i in 0..4){
            for (j in 0..4){
                //uses individual ids to see if clicked
                (view[i][j]).setOnClickListener {
                    checker(view, i, j, butts)
                }
            }
        }
    }

    private fun show(view: List<List<Button>>) { //shows the buttons/lights
        for (i in 0..4) {
            for (j in 0..4) {
                val obj = (view[i][j])
                if (obj.visibility == View.GONE) {
                    obj.visibility = View.VISIBLE
                } else {
                    //if its already visible, it means the rest are too, no need to show
                    break
                }
            }
        }
    }


    private fun retry(view: List<List<Button>>){ //resets the game without changing the name
        for (i in 0..4){
            for (j in 0..4){
                val temp = (view[i][j])
                temp.setTag(0)
                temp.setBackgroundColor(Color.parseColor("TEAL"))
            }
        }
    }

    private fun createArray(): List<List<Button>>{ //creates 5x5 array by creating 5 list arrays to represent each row then combining them to form the 2d array
         val first_row: List<Button> = listOf(
             binding.lights1,
             binding.lights2,
             binding.lights3,
             binding.lights4,
             binding.lights5

         )
        val second_row: List<Button> = listOf(
            binding.lights6,
            binding.lights7,
            binding.lights8,
            binding.lights9,
            binding.lights10
        )
        val third_row: List<Button> = listOf(
            binding.lights11,
            binding.lights12,
            binding.lights13,
            binding.lights14,
            binding.lights15

        )
        val fourth_row: List<Button> = listOf(
            binding.lights16,
            binding.lights17,
            binding.lights18,
            binding.lights19,
            binding.lights20
        )
        val fifth_row: List<Button> = listOf(
            binding.lights21,
            binding.lights22,
            binding.lights23,
            binding.lights24,
            binding.lights25
        )

        //Making of the 2d part
        val twoD_Array : List<List<Button>> = listOf(first_row,second_row,third_row,fourth_row,fifth_row)

        return twoD_Array
    }


}
