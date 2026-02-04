package WorkingWithFiles

import java.io.File

fun main() {
    val file = File("TODO list")
    while (true){
        print("Введите новое дело: ")
        val todo = readln()

        if (todo == "0"){
            println("Программа завершила работу")
            break
        }
        file.appendText("$todo\n")
    }



}