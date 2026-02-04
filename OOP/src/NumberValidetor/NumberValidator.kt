package NumberValidetor

object NumberValidator {

    /**
     * Завершает выполнение программы или выбрасывает исключение с заданным сообщением.
     * Возвращает тип Nothing.
     */
    fun terminate(message: String): Nothing {
       throw IllegalArgumentException(message)
    }

    /**
     * Проверяет число на корректность.
     * Если число некорректно, вызывает terminate.
     * @return то же число, если данные корректны.
     */
    fun validate(number: Int): Int {
        if (number < 0) terminate("Ошибка: Число отрицательное.")
        if (number == 0) terminate("Ошибка: Число равно нулю.")
        return number
    }
}