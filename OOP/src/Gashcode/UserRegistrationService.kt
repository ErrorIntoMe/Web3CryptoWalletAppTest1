package Gashcode

class UserRegistrationService {
    private val registeredUsers = mutableListOf<String>()

    // Метод для валидации данных пользователя
    fun validateUserData(username: String, password: String): Boolean {
        return username.isNotBlank() && password.length >= 8
    }

    // Метод для сохранения данных пользователя
    fun saveUser(username: String, passwordHash: String) {
        registeredUsers.add("$username:$passwordHash")
    }

    // Метод для регистрации пользователя
    fun registerUser(username: String, password: String): Boolean {
        if (!validateUserData(username, password)) {
            println("Invalid user data")
            return false
        }

        val passwordHash = PasswordHasher().hashPassword(password)
        saveUser(username, passwordHash)
        println("User registered successfully")
        return true
    }
}