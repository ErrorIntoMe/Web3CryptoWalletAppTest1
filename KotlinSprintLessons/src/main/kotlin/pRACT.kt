package org.example

import kotlin.math.PI
import kotlin.math.pow

fun main(){
//    print("Enter number a: ")
//    val a = readln().toDouble()
//    print("Enter number a symbol +/-*: ")
//    val symbol = readln().toString()
//    print("Enter number b: ")
//    val b = readln().toDouble()
//    if (symbol == "+"){
//        print("${a+b}")
//    }
//    else if(symbol == "-" ){
//        print("${a-b}")
//    }
//    else if (symbol == "/"){
//        print("${a/b}")
//    }
//    else {
//        print(print("${a*b}"))
//    }


//    print("Enter you radiant: ")
////    val radiant = readln().toDouble()
////    val surface = PI*radiant.pow(2)
////    val longOfRadiant = 2*PI*radiant
////    print("""
////Радиус: $radiant
////Длина окружности: $longOfRadiant
////Площадь круга: $surface
////    """.trimIndent())

//    print("Enter number of month: ")
//    val month = readln().toInt()
//    val months = listOf<String>("Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь")
//    if (month in 1..12){
//    print( months[month-1])}
//    else print("Incorrect value")

//    val a = readln().toInt()
//    var sum = 0
//    var num = 0
//    while (num <= a){
//        sum +=num
//        num++
//    }
//    println("Сумма числе от 1 до $a равна: $sum")

//    val brand = readln().toString()
//    val list = listOf<String>("Toyota", "Mercedes", "BMW")
//    var brandValue = false
//    for (str in list){
//        if (brand == str){
//            brandValue = true
//        }
//    }
//    println(brandValue)
//


//    val a = readln().toInt()
//    val b = readln().toInt()
//    val num = a..b step 8
//    for (numbers in num){
//        println(numbers)
//    }

//    val teraByte = readln().toLong()
//    val res = teraByte * 1024 * 1024 * 1024 * 1024
//    println(res)

    val weight = readln().toInt()
    if (weight < 2){
        println("150 руб./км.")
    }
    else if (weight < 5 ){
    println("200 руб./км.")
    }
    else if (weight < 12){
        println("250 руб./км.")
    }
    else if (weight < 18){
        println("300 руб./км.")
    }
    else if (weight < 30){
        println("350 руб./км.")
    }
    else if (weight < 200){
        println("1000 руб./км.")
    }
    else if (weight >= 200){
        println("Для расчета стоимости свяжитесь с менеджером")
    }
    }
