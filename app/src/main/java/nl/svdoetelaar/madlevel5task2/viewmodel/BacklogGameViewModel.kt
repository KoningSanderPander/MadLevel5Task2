package nl.svdoetelaar.madlevel5task2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import nl.svdoetelaar.madlevel5task2.model.BacklogGame
import nl.svdoetelaar.madlevel5task2.repository.BacklogGameRepository

class BacklogGameViewModel(application: Application) : AndroidViewModel(application) {

    private val mainScope = CoroutineScope(Dispatchers.Main)
    private val backlogGameRepository = BacklogGameRepository(application.applicationContext)

    val backlogGameLiveData: LiveData<List<BacklogGame>> get() = backlogGameRepository.getAllBacklogGames()

    fun addBacklogGame(game: BacklogGame) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                backlogGameRepository.insertGame(game)
            }
        }
    }

    fun deleteGame(game: BacklogGame) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                backlogGameRepository.deleteGame(game)
            }
        }
    }

    fun deleteAllGames() {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                backlogGameRepository.deleteAllGames()
            }
        }
    }
}