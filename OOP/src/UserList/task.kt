package UserList

fun task(listUser: List<String>): List<String> {
    val users = mutableListOf<String>()
    val options = EnumUserList.entries
    for (str in listUser) {
        users.add(str)
    }
    println("Выберите функцию.")
    for ((index, code) in options.withIndex()) {
        print("$index - ${code.title}")
        if (index < options.size - 1) {
            print("\n")
        } else {
            print(": ")
            continue
        }
    }
    val operationIndex = readln().toInt()
    val operationCode = options[operationIndex]
    when (operationCode) {
        EnumUserList.ADD -> {
            println("Введите текст: ")
            val text = readln()
            users.add(text)
            println(users)
        }

        EnumUserList.SHOW -> {
            println(users)
        }

        EnumUserList.REMOVE -> {
            val textUser = readln()
            if (users.remove(textUser)) {
                println(users)
            } else {
                println("Иди нахуй")
            }

        }

        EnumUserList.REMOVE_AT -> {
            val textIndex = readln().toInt()
            users.removeAt(textIndex)
            println(users)
        }
    }
    return users.toList()
}


fun main() {
    val listUser = listOf<String>("user0", "user1", "user2", "user3", "user4", "user5", "user6", "user7", "user8", "user9")
    val userList = task(listUser)
}