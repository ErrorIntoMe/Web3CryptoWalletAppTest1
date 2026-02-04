package UserData

interface Repository {

    val list: List<UserData?>
        get() = listOf(
            UserData("Alice", "alice@example.com", 30),
            null,
            UserData(null, "guest@example.com", 25),
            UserData("Bob", null, null),
            UserData(null, null, null),
            UserData("Charlie", "charlie@example.com", 40),
            UserData(null, "no-email@example.com", 10),
            UserData("Diana", "diana@example.com", 0),
            UserData("Eve", null, 35),
            null
        )

    /**
     * Возвращает список пользователей, некоторые элементы или их поля могут быть null.
     */
    fun getUsers(): List<UserData?>{
        return list
    }


}