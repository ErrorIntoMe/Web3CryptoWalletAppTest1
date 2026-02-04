package Month

fun main() {
    val months = DaysOfWeek.entries
    for (months in months){
        println(months.title)
    }
}