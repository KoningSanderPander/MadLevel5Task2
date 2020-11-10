package nl.svdoetelaar.madlevel5task2.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import nl.svdoetelaar.madlevel5task2.databinding.FragmentAddGameBinding
import nl.svdoetelaar.madlevel5task2.model.BacklogGame
import nl.svdoetelaar.madlevel5task2.viewmodel.BacklogGameViewModel
import java.time.LocalDate

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddGameFragment : Fragment() {

    private val backlogGameViewModel: BacklogGameViewModel by viewModels()

    private lateinit var binding: FragmentAddGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabAddGame.setOnClickListener {
            addBacklogGameFormSubmit()
        }
    }

    private fun addBacklogGameFormSubmit() {

        val title = binding.etTitle.text.toString()
        val platform = binding.etPlatform.text.toString()
        val day = binding.etDay.text.toString().toInt()
        val month = binding.etMonth.text.toString().toInt()
        val year = binding.etYear.text.toString().toInt()

        if (title.isEmpty()) {
            Snackbar.make(requireView(), "Enter a title", Snackbar.LENGTH_SHORT).show()
            return
        }

        if (platform.isEmpty()) {
            Snackbar.make(requireView(), "Enter a platform", Snackbar.LENGTH_SHORT).show()
            return
        }

        try {
            backlogGameViewModel.addBacklogGame(
                BacklogGame(
                    title,
                    platform,
                    LocalDate.of(year, month, day)
                )
            )
            startActivity(Intent(activity, GamesBacklogActivity::class.java))
        } catch (e: Exception) {
            Snackbar.make(requireView(), "Invalid date try again", Snackbar.LENGTH_SHORT).show()
        }

    }
}