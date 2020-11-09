package nl.svdoetelaar.madlevel5task2.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import nl.svdoetelaar.madlevel5task2.model.BacklogGame

@Dao
interface BacklogGameDAO {

    @Query("SELECT * FROM BacklogGame")
    fun getAllGames(): LiveData<List<BacklogGame>>

    @Insert
    fun insertGame(backlogGame: BacklogGame)

    @Delete
    fun deleteGame(backlogGame: BacklogGame)

    @Query("DELETE FROM BacklogGame")
    suspend fun deleteAllGames()
}