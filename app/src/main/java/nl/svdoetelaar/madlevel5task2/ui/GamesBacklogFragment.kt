package nl.svdoetelaar.madlevel5task2.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import nl.svdoetelaar.madlevel5task2.R
import nl.svdoetelaar.madlevel5task2.databinding.FragmentGamesBacklogRvBinding
import nl.svdoetelaar.madlevel5task2.model.BacklogGame
import nl.svdoetelaar.madlevel5task2.viewmodel.BacklogGameViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GamesBacklogFragment : Fragment() {

    private val backlogGameViewModel: BacklogGameViewModel by viewModels()

    private val backlogGames = arrayListOf<BacklogGame>()
    private val backlogGameAdapter = BacklogGameAdapter(backlogGames)

    private lateinit var binding: FragmentGamesBacklogRvBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGamesBacklogRvBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRv()
        observeLiveData()

        binding.fabAddGame.setOnClickListener {
            startActivity(Intent(activity, AddGameActivity::class.java))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.deleteAll -> {
                backlogGameViewModel.deleteAllGames()
                backlogGameAdapter.notifyDataSetChanged()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun observeLiveData() {
        backlogGameViewModel.backlogGamesLiveData.observe(
            viewLifecycleOwner,
            { liveBacklogGames: List<BacklogGame> ->
                backlogGames.clear()
                backlogGames.addAll(liveBacklogGames)
                backlogGames.sortBy { it.date }
                backlogGameAdapter.notifyDataSetChanged()
            })
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initRv() {
        binding.rvGames.apply {
            adapter = backlogGameAdapter
            layoutManager = LinearLayoutManager(activity)
        }

        createItemTouchHelper().attachToRecyclerView(binding.rvGames)
    }

    private fun createItemTouchHelper(): ItemTouchHelper {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT
        ) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val backlogGame = backlogGames[position]
                val undoSnackBar = Snackbar.make(
                    requireView(),
                    getString(R.string.removed_one_game),
                    Snackbar.LENGTH_SHORT
                ).setAction(getString(R.string.undo), fun(_: View) {
                    backlogGameViewModel.addBacklogGame(backlogGame)
                })

                backlogGameViewModel.deleteGame(backlogGame)

                undoSnackBar.show()
            }

        }

        return ItemTouchHelper(callback)
    }
}