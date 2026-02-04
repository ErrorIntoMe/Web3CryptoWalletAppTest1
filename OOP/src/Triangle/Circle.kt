package Triangle

import kotlin.math.PI

class Circle(
    name: String = "Окружность",
    private val radius: Double = 5.0
): Shape(name = name) {

    override fun area(): Double {
        val area = 2 * PI * radius * radius
        return area
    }

    override fun perimeter(): Double {
        val perimeter = 2 * PI * radius
        return perimeter
    }
}