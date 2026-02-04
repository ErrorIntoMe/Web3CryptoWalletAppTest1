package Corporation

class Shoes(
    name: String = "",
    brand: String = "",
    price: Int = 0,
    var size: Int = 0,
    var color: String = ""
): ProductCard() {

    override fun cardWriting() {
        super.cardWriting()
        print("Введите размер: ")
        size = readln().toInt()
        print("Введите цвет: ")
        color = readln().toString()

    }

    override fun printInfo() {
        super.printInfo()
        println("""
            Size: $size
            Color: $color
        """.trimIndent())
    }
}