package Monster

import Monster.Monster

fun main() {
    val str = readln().split(" ")
    val countOfPow = str[0].toInt()
    val eyesCount =  str[1].toInt()
    val fangsCount = str[2].toInt()
    val clawsCount =  str[3].toInt()
    val tentaclesCount = str[4].toInt()
    val monster = Monster(countOfPow, eyesCount, fangsCount, clawsCount, tentaclesCount)
    monster.printInfo()
}