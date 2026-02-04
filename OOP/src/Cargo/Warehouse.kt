package Cargo

class Warehouse {

    fun getPack(deliveryObject: DeliveryObject): Pack {
        val lenght = deliveryObject.length + 1
        val widght = deliveryObject.width + 1
        val  height = deliveryObject.height + 1
        return Pack(lenght, widght, height, weight = 0.3)
    }
    fun packCargo(deliveryObject: DeliveryObject, pack: Pack): Cargo {
        val lenght = pack.length
        val widght = pack.width
        val  height = pack.height
        val weight =  deliveryObject.weight
        val grossWeight = weight + 0.3
        return Cargo(lenght, widght, height, netWeight = weight, grossWeight = grossWeight)
    }
}