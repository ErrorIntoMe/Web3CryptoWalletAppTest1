package WorkingWithFiles

import java.io.File

fun main() {

    val operationCode = Codes.entries
    val file = File("TODO LIST WITH SHOWING.txt")
    while (true) {
        print("Выберите действие.")
        for ((index, code) in operationCode.withIndex()) {
            print("$index - ${code.title}")
            if (index < operationCode.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val operationCodeIndex = readln().toInt()
        val operation = operationCode[operationCodeIndex]
        when (operation) {
            Codes.EXIT -> break
            Codes.REGISTER_NEW_TODO -> {
                val text = readln()
                file.appendText("$text\n")
            }

            Codes.SHOW_TODO_LIST -> {
                val context = file.readText().trim().split("\n")
//                val text = context.split("\n")
                for ((index, code) in context.withIndex()) {
                    print("$index - $code")
                    if (index < operationCode.size-1) {
                        print("\n")
                    } else {
                        print(".\n")
                    }
                }

            }

        }

    }

}
