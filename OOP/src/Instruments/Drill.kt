package Instruments

class Drill(
    brand: String,
    model: String,
    power: Int,
    weight: Double,
    cableLength: Int,
    price: Price,
    voltage: Int,
    val drillChuckDiameter: Int,  //диаметр сверлильного патрона
    val minRotationSpeed: Int, //минимальная скорость вращения
    val maxRotationSpeed: Int //максимальная скорость вращения
): PowerTool(brand, model, power, weight, cableLength, price, voltage) {


    override fun turnOn() {
        println("Сверлит...")
    }
}