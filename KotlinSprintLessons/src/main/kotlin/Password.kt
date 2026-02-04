package org.example

fun main()

{//Проверка условий if else
    //Проверка возраста
    println("Enter your age")
    val ageOfUser=readln().toInt()
    if (ageOfUser>=AGE_OF_MAJORITY)
    {
        println("Enter your password")
        val password=readln().toInt()
        if (password == RIGHT_PASSWORD) {
            println("Welcome to your account")
        }
        else println("Wrong password")
    }
    else if (ageOfUser == 16|| ageOfUser == 17){
        println("Welcome to Limited homepage")
        println("Enter your password")
        val password=readln().toInt()
        if (password == RIGHT_PASSWORD) {
            println("Welcome to your account")
        }
        else println("Wrong password")
    }
    else println("Иди нахуй")}