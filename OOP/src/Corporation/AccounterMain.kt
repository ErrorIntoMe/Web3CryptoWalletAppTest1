package Corporation

fun main() {
    val director = Director(222, "Rustem", 20)
    val assistant = Assistant(312312, "Sergey", age = 20)
    val consultant = Consultant(213213, "Maxim", 20)
    val accounter = Accounter(23213, "Rustem", 20)
//    val workers = listOf<Worker>(director, assistant, consultant, accounter)
//    for (employee in workers){
//        employee.work()
//    }
    val listOfWorker: MutableList<Worker> = mutableListOf(accounter, assistant, consultant, director)
    for (workers in listOfWorker){
        if (workers is Supplier){
            workers.supply()
        }
    }

//accounter.work()
}