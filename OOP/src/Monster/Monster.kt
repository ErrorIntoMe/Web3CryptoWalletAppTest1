package Monster

import kotlin.random.Random

class Monster(
    val pawsCount: Int,
    val eyesCount: Int,
    val fangsCount: Int,
    val clawsCount: Int,
    val tentaclesCount: Int
) {
    constructor(value: Int): this(value, value, value, value, value)
    constructor(): this(value = Random.Default.nextInt(1,10))

    fun printInfo(){
        println("""
            Кол-во лап: $pawsCount
            Кол-во глаз: $eyesCount
            Кол-во клыков: $fangsCount
            Кол-во когтей: $clawsCount
            Кол-во щупалец: $tentaclesCount
        """.trimIndent())
    }
}