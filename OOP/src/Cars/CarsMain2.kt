package Cars



fun serialize(car: Car): String {
    val make = car.make
    val model = car.model
    val year = car.year
    val vin = car.vin
    val color = car.color
    val carAsString = "$make%$model%$year%$year%$vin%$color"
    return carAsString
}

fun deserialize(carAsString: String): Car {
    val car = carAsString.split("%")
    val make = car[0]
    val model = car[1]
    val year = car[2].toInt()
    val vin= car[3]
    val color = car[4]
    val carReturn = Car(make, model, year, vin, color)
    return carReturn
}


fun main() {
    val cars = Car("kia", "rio", 2000, "2345", "yellow")
    println(serialize(cars))
}