package nl.svdoetelaar.madlevel5task2.repository

import android.content.Context
import androidx.lifecycle.LiveData
import nl.svdoetelaar.madlevel5task2.dao.BacklogGameDAO
import nl.svdoetelaar.madlevel5task2.database.BacklogGamesListRoomDatabase
import nl.svdoetelaar.madlevel5task2.model.BacklogGame

class BacklogGameRepository(context: Context) {

    private val backlogGameDao: BacklogGameDAO

    init {
        val database = BacklogGamesListRoomDatabase.getDatabase(context)
        backlogGameDao = database!!.BacklogGameDao()
    }

    fun getAllGames(): LiveData<List<BacklogGame>> {
        return backlogGameDao.getAllGames()
    }

    fun insertGame(game: BacklogGame) {
        backlogGameDao.insertGame(game)
    }

    suspend fun deleteAllGames() {
        backlogGameDao.deleteAllGames()
    }

    fun deleteGame(game: BacklogGame) {
        backlogGameDao.deleteGame(game)
    }
}