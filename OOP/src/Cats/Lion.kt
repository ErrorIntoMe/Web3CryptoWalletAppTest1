package Cats

class Lion( val countOfAnimalsInPride: Int = 10): CatsFamily() {

    override fun eating() {
        super.eating()
        println(" аннтелопу")
    }
}