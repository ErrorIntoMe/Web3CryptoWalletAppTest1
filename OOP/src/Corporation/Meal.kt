package Corporation

class Meal(
    name: String = "",
    brand: String = "",
    price: Int = 0,
    var colories: Int = 0,
    var count: Int = 0
): ProductCard() {

    override fun cardWriting() {
        super.cardWriting()
        print("Введите количество каллорий: ")
        colories = readln().toInt()
        print("Введите количество товара: ")
        count = readln().toInt()
    }

    override fun printInfo() {
        super.printInfo()
        println("""
            Colories: $colories
            Count: $count
        """.trimIndent())
    }
}