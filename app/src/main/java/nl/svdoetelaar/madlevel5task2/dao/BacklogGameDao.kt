package nl.svdoetelaar.madlevel5task2.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import nl.svdoetelaar.madlevel5task2.model.BacklogGame

@Dao
interface BacklogGameDao {

    @Query("SELECT * FROM BacklogGame")
    fun getAllBacklogGames(): LiveData<List<BacklogGame>>

    @Insert
    fun insertBacklogGame(backlogGame: BacklogGame)

    @Delete
    fun deleteBacklogGame(backlogGame: BacklogGame)

    @Query("DELETE FROM BacklogGame")
    suspend fun deleteAllBacklogGames()
}