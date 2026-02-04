package Cats

fun main() {
    val cat = Cats("Max")
    val lion = Lion(10)
    cat.eating()
    lion.eating()
    println("${cat.name}, ${cat.countOfLegs}")
    println("${lion.countOfAnimalsInPride}, ${lion.countOfLegs}")

}
