package Corporation

import kotlin.random.Random

class Consultant(
     id: Int,
     name: String,
     age: Int
): Worker(id, name, age) {
    override fun work() {
        println("Работаю с клиентами...")
    }

    fun sayHello(){
        println("Привет меня зовут, $name")
        if (age != 0){
        println("Мне $age лет")}
    }

    fun workWithClients(): Int{
        val count = Random.Default.nextInt(1, 100)
        repeat(count){
            println("Обслужен клиент")
        }
            return count
    }

}