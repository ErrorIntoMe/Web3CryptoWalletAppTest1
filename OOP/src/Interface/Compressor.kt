package Interface

class Compressor(
    processorName: String = "Compressor"
): DataProcessor(processorName), Transformable {

    override fun process(data: String): String {
        return super.process(data)
    }

    override fun transform(data: String): String {
        return "$processorName преобразовал данные: compressed_$data"
    }
}