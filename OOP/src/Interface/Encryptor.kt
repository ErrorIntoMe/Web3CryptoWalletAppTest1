package Interface

class Encryptor(
   processorName: String = "Encryptor"
): DataProcessor(processorName), Transformable {


    override fun process(data: String): String {
        return super.process(data)
    }

    override fun transform(data: String): String {
        return "$processorName преобразовал данные: encoded_$data"
    }
}