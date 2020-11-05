package nl.svdoetelaar.madlevel5task2.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_games.*
import kotlinx.android.synthetic.main.activity_games.view.*
import nl.svdoetelaar.madlevel5task2.R
import nl.svdoetelaar.madlevel5task2.databinding.FragmentAddGameBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddGameFragment : Fragment() {

    private lateinit var binding: FragmentAddGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddGameBinding.inflate(inflater, container, false)
        (activity as GamesActivity).setToolbarWithBackButton()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabAddGame.setOnClickListener {
            (activity as GamesActivity).setToolbarWithoutBackButton()
            findNavController().popBackStack()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.setGroupVisible(id, false)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onResume() {
        super.onResume()
        (activity as GamesActivity).setSupportActionBarTitle(getString(R.string.add_game))
    }
}