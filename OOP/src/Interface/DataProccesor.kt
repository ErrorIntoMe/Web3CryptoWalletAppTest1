package Interface

abstract class DataProcessor (
    val processorName: String
) {

    open fun process(data: String): String{
        return "Обработчик: $processorName обработал данные"
    }

}