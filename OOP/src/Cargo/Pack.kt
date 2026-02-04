package Cargo

class Pack(
    val length: Int,
    val width: Int,
    val height: Int,
    val type: String = "Картонная коробка",
    val weight: Double,
) {
    fun printInfo(){
        println("""
            Длина: $length
            Ширина: $width 
            Высота: $height 
            Тип упаковки: $type
            Вес : ${weight}
        """.trimIndent())
    }
}