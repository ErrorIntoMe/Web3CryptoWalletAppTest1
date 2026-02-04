package Instruments

class AngleGrinder(
    brand: String,
    model: String,
    power: Int,
    weight: Double,
    cableLength: Int,
    price: Price,
    voltage: Int,
    val discDiameter: Int ,//- диаметр диска
    val isSmoothStart: Boolean,//- наличие системы плавного пуска
    val isDustProtection: Boolean, //- наличие защиты от пыли
):  PowerTool(brand, model, power, weight, cableLength, price, voltage) {

    override fun turnOn() {
        println("Пилит...")
    }
}