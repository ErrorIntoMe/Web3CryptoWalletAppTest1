package Corporation

class Assistant(
    id: Int,
    name: String,
    age: Int,
    val count: Int = 1,
    val typeOfCoffee: String = "Capucino"
): Worker(id, name, age), Supplier {

    override fun supply() {
        println("Я ассистент. Я убираю свое рабочее место...")
    }

    override fun work() {
        println("Несу кофе...")
    }

    fun bringCoffee() {
        repeat(count) {
            println("Встать")
            println("Дойти до кофемашины")
            println("Нажать на кнопку $typeOfCoffee")
            println("Подождать приготовления")
            println("Принести кофе")
        }
    }


}