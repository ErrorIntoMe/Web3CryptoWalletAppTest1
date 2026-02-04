package Orders

fun removeCompletedOrders(orders: List<Order>, typeToRemove: String): List<Order> {

//    val orders = orders.filterNot { it.type == typeToRemove && it.status == "completed" }
//    return orders.toList()
    // .filterNot проходится по всему списку и удаляет элементы которые возвращают true по заданным условиям
    // .filter  проходится по всему списку и оставляет элементы которые возвращают true по заданным условиям
    val orders2 = orders.toMutableList()
    val typeOfOrder = typeToRemove
    for (index in orders2.size-1 downTo 0) {
        val code = orders2[index]
        if (code.type == typeOfOrder && code.status == "completed") {
            orders2.remove(code)
        }
    }
    return orders2.toList()
}


fun main() {
    print("Введите тип удаляемого заказа: ")
    val typeToRemove = readln()
    val order1 = Order(213213, "completed", "Electronics")
    val order2 = Order(213213, "completed", "Electronics")
    val order3 = Order(213213, "canceled", "furniture")
    val listOfOrders = listOf(order1, order3, order2)
    println(listOfOrders)
    val newListOfOrders = removeCompletedOrders(listOfOrders, typeToRemove)
    println(newListOfOrders)
}