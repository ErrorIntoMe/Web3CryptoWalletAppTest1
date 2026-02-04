package Instruments

fun main() {
    val price = Price(10, 10, 10)
    val drill = Drill("", "", 10, 10.0, 10, price, 220, 100, 100,100)
    val angleGrinder = AngleGrinder("", "", 10, 10.0, 10, price, 220, 100, true,true)
    val chainSaw = ChainSaw("", "", 10, 10.0, 10, price, 220, 100, 100,100.0)
    val instruments = listOf<PowerTool>(drill, angleGrinder, chainSaw)
    for (tools in instruments){
        tools.turnOn()
    }
}