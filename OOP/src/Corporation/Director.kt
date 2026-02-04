package Corporation

class Director(
    id: Int,
    name: String,
    age: Int
): Worker(id, name, age), Supplier {

    override fun supply() {
        println("Я директор. Я убираю свое рабочее место...")
    }

    override fun work(){
        println("Пью кофе...")
    }


    fun takeCoffee(assistant: Assistant){
        assistant.bringCoffee()
        println("Thanks, ${assistant.name}. This ${assistant.typeOfCoffee}  is good!")
    }

    fun checkConsultant(consultant: Consultant,){
        val count = consultant.workWithClients()
        println("${consultant.name}, is served $count clients")
    }

}