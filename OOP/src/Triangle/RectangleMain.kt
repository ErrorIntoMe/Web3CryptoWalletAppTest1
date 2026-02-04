package Triangle

fun main() {
    val height = readln().toInt()
    val width = readln().toInt()
    val rectangle = Rectangle(height, width)
    rectangle.draw()
}