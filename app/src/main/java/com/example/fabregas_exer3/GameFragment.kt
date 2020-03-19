gipackage com.example.fabregas_exer3

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.fabregas_exer3.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding

    //declared as global so that it can be used by other functions without passing
    private var lights_off: Int = 0;
    private var num_of_clicks: Int = 0;
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater,R.layout.fragment_game,container,false)
        binding.name.text = "Go " + this.arguments?.get("player").toString() + " !!"
        var array = createArray()
        binding.retry.setOnClickListener {
            retry(array);
        }
        run(array,binding.retry);


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
            view.setBackgroundColor(Color.CYAN)
            view.setTag(0)

            this.lights_off -= 1
        }else{
            view.setBackgroundColor(Color.parseColor("Teal"))
            view.setTag(1)
            this.lights_off += 1
        }

    }

    private fun run(list: List<List<Button>>, butts: Button){ //the whole game process
        for (i in 0..4){
            for (j in 0..4){
                //uses individual ids to see if clicked
                (list[i][j]).setOnClickListener {
                    checker(list, i, j, butts)
                    this.num_of_clicks+=1
                    //putted this on a set click listener because if you pur it on onCreate it only checks on the initialization and not the whole game mechanism
                    if(this.lights_off>=25) { view?.findNavController()?.navigate(R.id.action_gameFragment_to_congratulationFragment,
                        bundleOf("clicks" to this.num_of_clicks, "name" to this.arguments?.get("player").toString())) };
                }
            }
        }

    }



    private fun retry(view: List<List<Button>>){ //resets the game without changing the name
        for (i in 0..4){
            for (j in 0..4){
                val temp = (view[i][j])
                temp.setTag(0)
                temp.setBackgroundColor(Color.CYAN)
            }
        }
        this.lights_off = 0;
        this.num_of_clicks = 0;
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
