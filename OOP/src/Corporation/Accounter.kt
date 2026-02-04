package Corporation

import java.io.File
import kotlin.random.Random

class Accounter(
    id: Int,
    name: String,
    age: Int
) : Worker(id, name, age), Supplier {


    override fun supply() {
        println("Я бухгалтер. Я убираю свое рабочее место...")
    }


    val items = mutableListOf<ProductCard>()

    override fun work() {
        val products = Products.entries
        val options = Options.entries
        val fileWorkers = File("ListOfWorkers.txt")
        while (true) {
            println("Введите код операции.")
            for ((index, code) in options.withIndex()) {
                print("$index - ${code.title}\n")
            }
            val value = readln().toInt()
            when (value) {
                1 -> {
                    print("Выберите категорию товара.")
                    for ((index, code) in products.withIndex()) {
                        print("$index - ${code.title}")
                        if (index < products.size - 1) {
                            print(", ")
                        } else {
                            print(": ")
                        }
                    }
                    val value1 = readln().toInt()
                    var productCard = ProductCard()
                    when (value1) {
                        0 -> {
                            productCard = Shoes()
                            productCard.cardWriting()
                            items.add(productCard)
                        }

                        1 -> {
                            productCard = Meal()
                            productCard.cardWriting()
                            items.add(productCard)
                        }

                        2 -> {
                            productCard = Technic()
                            productCard.cardWriting()
                            items.add(productCard)
                        }
                    }
                }

                2 -> {
                    this.printInfoCard()
                }

                3 -> {
                    val id = Random.nextInt(0, 100)
                    fileWorkers.appendText("$id%")
                    print("Enter name: ")
                    val name = readln()
                    fileWorkers.appendText("$name%")
                    print("Enter age: ")
                    val age = readln().toInt()
                    fileWorkers.appendText("$age%")
                    print("Enter employee: ")
                    val employee = readln()
                    fileWorkers.appendText("$employee\n")
                }

                4 -> {
                    print("Id of worker: ")
                    val value = readln().toInt()
                    val text = fileWorkers.readText().trim().split("\n")
                    val listText = text.toMutableList()
                    for (str in listText) {
                        if (!str.startsWith("$value")) {
                            fileWorkers.writeText(str)
                        }

                    }
                }

                5 -> {
                    val readTextFile = fileWorkers.readText().trim().split("\n")
                    for (str in readTextFile) {
                        val oneEmployee = str.split("%")
                        val id = oneEmployee[0]
                        val name = oneEmployee[1]
                        val age = oneEmployee[2]
                        val employee = oneEmployee[3]
                        println("Id: $id, Name: $name, Age: $age, Employee: $employee")
                    }
                }

                else -> {
                    println("Программа остановлена")
                    break
                }
            }
        }
    }


//    fun loadAllEmployee(): MutableList<Worker>{
//        val employee = mutableListOf<Worker>()
//    }

    fun printInfoCard() {
        for (item in items) {
            item.printInfo()
        }
    }

}


