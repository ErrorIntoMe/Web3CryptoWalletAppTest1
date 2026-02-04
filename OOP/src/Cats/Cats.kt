package Cats

class Cats(val name: String): CatsFamily() {


    override fun eating() {
        super.eating()
        println(" Whiskas")
    }
}