package nl.svdoetelaar.madlevel5task2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import nl.svdoetelaar.madlevel5task2.dao.BacklogGameDAO
import nl.svdoetelaar.madlevel5task2.model.BacklogGame

@TypeConverters(Converter::class)
@Database(entities = [BacklogGame::class], version = 1, exportSchema = false)
abstract class BacklogGamesListRoomDatabase : RoomDatabase() {

    abstract fun BacklogGameDao(): BacklogGameDAO

    companion object {
        private const val DATABASE_NAME = "BACKLOG_GAME_DATABASE"

        @Volatile
        private var gameDatabaseInstance: BacklogGamesListRoomDatabase? = null

        fun getDatabase(context: Context): BacklogGamesListRoomDatabase? {
            if(gameDatabaseInstance == null) {
                synchronized(BacklogGamesListRoomDatabase::class.java) {
                    if(gameDatabaseInstance == null) {
                        gameDatabaseInstance = Room.databaseBuilder(
                            context.applicationContext,
                            BacklogGamesListRoomDatabase::class.java,
                            DATABASE_NAME
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return gameDatabaseInstance
        }
    }
}