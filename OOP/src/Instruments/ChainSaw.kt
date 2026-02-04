package Instruments

class ChainSaw(
    brand: String,
    model: String,
    power: Int,
    weight: Double,
    cableLength: Int,
    price: Price,
    voltage: Int,
    val chainSawTireLength: Int, //- длина шины
    val chainLinksCount: Int, //- кол-во звеньев цепи
    val chainStep: Double, //- шаг цепи
):  PowerTool(brand, model, power, weight, cableLength, price, voltage) {

    override fun turnOn() {
        println("Режет...")
    }
}