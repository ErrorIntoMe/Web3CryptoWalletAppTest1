package Cats

open class CatsFamily(
    val countOfLegs: Int = 4
) {


    open fun eating(){
        print("Кушаю")
    }
}