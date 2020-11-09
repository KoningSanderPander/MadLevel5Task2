package nl.svdoetelaar.madlevel5task2.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class BacklogGame (
    var name: String,
    var platform: String,
    var date: LocalDate,

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
)