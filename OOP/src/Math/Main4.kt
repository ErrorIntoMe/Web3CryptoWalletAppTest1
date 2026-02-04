package Math

fun processExpressions() {
    val expressions = listOf("10 + 5", "20 / 0", "abc * 5", "15 ^ 2", "30 / 5")

    for (expression in expressions) try {
        val result = MathEvaluator.evaluate(expression) // TODO: Добавить обработку ошибок
        println("Результат выражения '$expression': $result")
    } catch (exception: ArithmeticException) {
        println("Ошибка: Деление на ноль.")
    } catch (exception: Throwable){
        println("Ошибка: Некорректное выражение.")
    }
}