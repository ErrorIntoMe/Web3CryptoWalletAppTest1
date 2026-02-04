package NumberValidetor

/**
 * Функция обработки числа.
 * Проверяет число с помощью NumberValidator.validate и выводит результат.
 */
fun main() {
    processNumber(-1)
}


//Принимает целое число.
//Проверяет его с помощью метода validate объекта NumberValidator.
//Использует блок try-catch для обработки исключений. (Если выброшено исключение, можно обратиться к его свойству message для получения текста ошибки.)
//Выводит число или сообщение об ошибке, если число некорректное.
fun processNumber(number: Int) {
    try {
        val result = NumberValidator.validate(number)
        println("Число: $result")
    } catch (exception: IllegalArgumentException){
        println(exception.message)
    }

}