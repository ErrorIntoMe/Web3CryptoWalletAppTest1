package org.example
fun main(){

    val password  = readln().toCharArray()
    var truefalse = false
    for (chr in password){
        if (chr == 'ъ' || chr == 'Ъ'){
            truefalse = true
        }
    }
        if (truefalse){
    println("У вас идеальный пароль!")
}
        else
            println("Опс! В вашем пароле кое-чего не хватает.")
}

