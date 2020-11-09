package nl.svdoetelaar.madlevel5task2.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import nl.svdoetelaar.madlevel5task2.R
import nl.svdoetelaar.madlevel5task2.databinding.FragmentGamesBacklogRvBinding
import nl.svdoetelaar.madlevel5task2.model.BacklogGame
import java.time.LocalDate

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GamesBacklogFragment : Fragment() {

    private val backlogGames = listOf(BacklogGame("Doom Eternal", "PC", LocalDate.now()),
        BacklogGame("Call of duty", "PS4, XBOX 1", LocalDate.now()),
        BacklogGame("Mario Krat", "Wii Switch", LocalDate.now())
    )
    private val backlogGameAdapter = BacklogGameAdapter(backlogGames)

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