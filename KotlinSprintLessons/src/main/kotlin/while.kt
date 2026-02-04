package org.example
//Тест функции While
fun main()
{
    var a=10
    while (a>0){
        println("${a--}")
        Thread.sleep(1000)
    }
}