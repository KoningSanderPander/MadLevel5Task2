package nl.svdoetelaar.madlevel5task2.ui

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import nl.svdoetelaar.madlevel5task2.R
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
        binding = FragmentGamesBacklogRvBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabAddGame.setOnClickListener {
            startActivity(Intent(activity, AddGameActivity::class.java))
        }
    }
}