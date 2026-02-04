package Triangle

class Rectangle {
    val height: Int
    val width: Int

    constructor(height: Int, width: Int){
        this.height = height
        this.width = width
    }
    constructor(size: Int): this (size, size)

    fun draw(){
        repeat(height){
            println("*".repeat(width))
        }
    }
}