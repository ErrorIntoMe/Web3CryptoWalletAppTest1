package User

class Person (
    private val name: String,
    private val age: Int,
    private val height: Int,
    private val gender: String
){


    fun sayHello(){
        println("Hello ny name is $name")
    }
    fun running(){
        println("Im running\n".repeat(10))
    }
    fun userInfo(){
        println("""
        Name: $name
        Age: $age
        Height: $height
        Gender: $gender
    """.trimIndent())
    }

}