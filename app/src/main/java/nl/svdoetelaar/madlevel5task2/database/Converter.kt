package nl.svdoetelaar.madlevel5task2.database

import androidx.room.TypeConverter
import java.time.LocalDate
import java.util.*

class Converter {
    @TypeConverter
    fun fromTimestamp(value: String?): LocalDate? {
        return value?.let { LocalDate.parse(it) }
    }

    @TypeConverter
    fun dateToTimestamp(localDate: LocalDate?): String? {
        return localDate?.toString()
    }
}