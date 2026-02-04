package Corporation

class Technic(
    name: String = "",
    brand: String = "",
    price: Int = 0,
    var power: Int = 220,
    var type: String = ""
): ProductCard() {


    override fun cardWriting() {
        super.cardWriting()
        print("Введите мощность товара: ")
        power = readln().toInt()
        print("Введите тип техники: ")
        type = readln().toString()

    }

    override fun printInfo() {
        super.printInfo()
        println("""
            Power: $power
            Type: $type
        """.trimIndent())
    }
}