package User

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    print("Enter your name: ")
    val name = readln().toString()
    print("Enter your age: ")
    val age = readln().toInt()
    print("Enter your height: ")
    val height = readln().toInt()
    print("Enter your gender:")
    val gender = readln().toString()
    val User: Person = Person(name, age, height, gender)
    User.userInfo()
    User.sayHello()
}