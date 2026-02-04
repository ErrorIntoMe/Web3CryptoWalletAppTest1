package Cargo

import Cargo.Warehouse

fun main() {
    val str = readln().split(" ")
    val lenght = str[0].toInt()
    val width = str[1].toInt()
    val height = str[2].toInt()
    val weight = str[3].toDouble()
    val deliveryObject = DeliveryObject(lenght, width, height, weight)
    val warehouse = Warehouse()
    val pack = warehouse.getPack(deliveryObject)
    val cargo = warehouse.packCargo(deliveryObject, pack)
    cargo.printInfo()

}