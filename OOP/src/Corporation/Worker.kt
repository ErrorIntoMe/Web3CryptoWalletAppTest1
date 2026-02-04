package Corporation

open class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0
) {

    open fun work(){
        println("Я работаю")
    }
}