package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main()
{
    //Это проверка кода
    /*Это многострочная
    проверка кода, давай учиться вместе
     */

    // Проверка интерполяции
  val phrase1= "Hello"
    val phrase2= "Maksim"
    val phrase3= "Whats the next step of operation?"
    println("$phrase1,  $phrase2!  $phrase3")

        //Проверка multisring
    val TXT=""" 
                 |Maksim LOX
        |Egor LOX
            |Daniil LOX
    """.trimMargin()
    println(TXT)// Код выводит 3 строки выровненых под один уровень

//Проверка константы
    val Maksim=readln().toInt()
    val HeightOfMaksim=readln().toInt()
    val Age: Boolean = (Maksim >= AGE_OF_MAJORITY)
    val Height: Boolean = (HeightOfMaksim>= HEIGHT_OF_MAJORITY)
    println("Result of age and height! $Age, $Height")// Выводит равенство между переменными

    //Проверка In
    val Maksim2=21
    val Result1= Maksim2 !in AGE_OF_MAJORITY..AGE_OF_ELDER_MAJORITY
    println("This is your reuslt! $Result1")// Функция In помогает определить схожесть по двум условиям

    //Проверка и &&, или ||, нет !
    val Maksim3=35
    val Result2= (Maksim3 >= AGE_OF_MAJORITY) || (Maksim3 >= AGE_OF_ELDER_MAJORITY)
    println("This is your reuslt! $Result2")
/*
    Функция "и", позволяет определить схожесть в двух условиях сразу,
    если хоть одно условие не верно, ответ будет false

    Функция "или",
    позволяют определить схожесть двух уловий сразу,
    если хоть одно уловие будет верно, то ответ будет true

    Функция "нет" позволяет инверттировать параметры сравнения,
    поменят больше на меньше или с равно на неравно
 */

    //Проверка массивов
    val human="Egor"
    val characters= human[5]
    println(characters)


    }
//Проверка константы
const val AGE_OF_MAJORITY=18
const val AGE_OF_ELDER_MAJORITY=65
const val HEIGHT_OF_MAJORITY=190
const val RIGHT_PASSWORD=5451