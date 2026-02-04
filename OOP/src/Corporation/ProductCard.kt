package Corporation

open class ProductCard(
    var name: String = "",
    var brand: String = "",
    var price: Int = 0,
) {

    open fun cardWriting(){
        print("Введите название товара: ")
        name = readln().toString()
        print("Введите бренд товара: ")
        brand = readln().toString()
        print("Введите цену товара: ")
        price = readln().toInt()
    }


    open fun printInfo(){
        println("Ваша карточка товара")
        println("""
            Name: $name
            Brand: $brand
            Price: $price
        """.trimIndent())
    }



}