package UserData

class UserViewModel(private val repository: Repository) {
    val repository1 = repository.getUsers().toMutableList()

    /**
     * Реализуйте метод getUserDescriptions, который:
     * 1. Получает данные из репозитория.
     * 2. Удаляет null элементы списка.
     * 3. Заменяет null значения в полях name, email и age на дефолтные.
     * 4. Формирует строки в формате: "Name: [name], Email: [email], Age: [age]".
     *
     * @return Список строк с описаниями пользователей.
     */
    fun getUserDescriptions(): List<String?>? {
        val strList = mutableListOf<String>()
        for (users in repository1) {
            if (users != null) {
                val name = users.name ?: "Unknown Name"
                val email = users.email ?: "Unknown Email"
                val age = users.age ?: 0

                strList.add("Name: $name, Email: $email, Age: $age")
            }
        }
        return strList
    }
}
