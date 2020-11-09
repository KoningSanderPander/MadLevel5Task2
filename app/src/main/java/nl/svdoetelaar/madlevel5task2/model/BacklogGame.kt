package nl.svdoetelaar.madlevel5task2.model

import java.time.LocalDate

data class BacklogGame (
    var name: String,
    var platform: String,
    var date: LocalDate,

    var id: Long? = null
)