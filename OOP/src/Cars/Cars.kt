package Cars

//class Car(
//    val brand: String,
//    val model: String,
//    val enginePower: Int,
//    val bodyColor: String
//) {


//    constructor(brand: String, model: String, enginePower: Int, bodyColor: String){
//        this.brand = brand
//        this.model = model
//        this.enginePower = enginePower
//        this.bodyColor = bodyColor
//    }

//    fun drive() {
//        if (enginePower >= 120) {
//            println("Еду быстро, но недалеко на $brand $model ")
//        } else println("Еду далеко, но небыстро на $brand $model")
//    }
//
//    fun refuel(gas: String, markOfGas: String, countOfGas: Int) {
//        println(
//            """
//            Произведена заправка на АЗС "${gas}"
//            Марка бензина: ${markOfGas}
//            Кол-во литров: ${countOfGas}
//        """.trimIndent()
//        )
//    }
//
//    fun printInfo() {
//        println("$brand $model $enginePower л.с. $bodyColor")
//    }
//}