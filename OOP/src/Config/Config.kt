package Config

class Config(

) {
    private var _timeout: Int = 30
    private var _maxRetries: Int = 3
    private var _loggingLevel: LogLevel = LogLevel.INFO


    public var timeout: Int
        get() = _timeout
        set(value) {
            if (value > 1 && value < 300) {
                _timeout = value
            } else println("Ошибка: Время ожидания должно быть в диапазоне от 1 до 300 секунд. Установлено значение по умолчанию.")
        }

    public var maxRetries: Int
        get() = _maxRetries
        set(value) {
            if (value > 0) {
                _maxRetries = value
            } else println("Ошибка: Максимальное количество повторных попыток не может быть отрицательным. Установлено значение по умолчанию.")
        }

    public var loggingLevel: LogLevel
        get() = _loggingLevel
        set(value) {
            if (value == LogLevel.FATAL || value == LogLevel.TRACE) {
                println("Ошибка: Уровень $value недоступен.")
            }
            else _loggingLevel = value
        }


    private var isDebugMode: Boolean = false
        get() {
            if (loggingLevel == LogLevel.DEBUG) {
                field = true
            }
            return field
        }
        set(value) {}


    private var isProductionMode: Boolean = false
        get() {
            if (loggingLevel == LogLevel.ERROR) {
                field = true
            }
            return field
        }
        set(value) {}


    fun printConfig() {
        println(
            "Время ожидания: $_timeout секунд\n" +
                    "Максимальное количество повторных попыток: $_maxRetries\n" +
                    "Уровень логирования: $_loggingLevel\n" +
                    "Режим отладки: $isDebugMode\n" +
                    "Режим продакшн: $isProductionMode"
        )
    }
}