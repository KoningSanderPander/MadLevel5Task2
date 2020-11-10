package nl.svdoetelaar.madlevel5task2.repository

import android.content.Context
import androidx.lifecycle.LiveData
import nl.svdoetelaar.madlevel5task2.dao.BacklogGameDao
import nl.svdoetelaar.madlevel5task2.database.BacklogGamesListRoomDatabase
import nl.svdoetelaar.madlevel5task2.model.BacklogGame

class BacklogGameRepository(context: Context) {

    private val backlogGameDao: BacklogGameDao

    init {
        val database = BacklogGamesListRoomDatabase.getDatabase(context)
        backlogGameDao = database!!.backlogGameDao()
    }

    fun getAllBacklogGames(): LiveData<List<BacklogGame>> {
        return backlogGameDao.getAllBacklogGames()
    }

    fun insertBacklogGame(game: BacklogGame) {
        backlogGameDao.insertBacklogGame(game)
    }

    suspend fun deleteAllBacklogGames() {
        backlogGameDao.deleteAllBacklogGames()
    }

    fun deleteBacklogGame(game: BacklogGame) {
        backlogGameDao.deleteBacklogGame(game)
    }
}