package User

import java.text.SimpleDateFormat
import java.util.Date

class LogEvent(
    val eventData: Any
) {


    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return dateFormat.format(Date())
    }

    override fun toString(): String {
        return "[${getCurrentDate()}]: $eventData"
    }
}