package nl.svdoetelaar.madlevel5task2.ui

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_games.*
import kotlinx.android.synthetic.main.activity_games.view.*
import nl.svdoetelaar.madlevel5task2.R
import nl.svdoetelaar.madlevel5task2.databinding.FragmentAddGameBinding
import nl.svdoetelaar.madlevel5task2.databinding.FragmentGamesBacklogRvBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GamesBacklogFragment : Fragment() {

    private lateinit var binding: FragmentGamesBacklogRvBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGamesBacklogRvBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabAddGame.setOnClickListener {
            onCreateOptionsMenu(toolbar.menu, MenuInflater(requireContext()))
            startActivity(Intent(requireContext(), AddGameActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.setGroupVisible(id, true)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onResume() {
        super.onResume()
        (activity as GamesActivity).setSupportActionBarTitle(getString(R.string.game_backlog))
    }
}