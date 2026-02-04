package domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import firstkmpproject.composeapp.generated.resources.Res
import kotlin.reflect.KClass


data class Student(var name: String) {

}

class Generic<out T>(val id: T, var name: String)

fun main() {
    val student = Student("1")
    val hashMap = HashMap<Int, Student>()
    hashMap[student.hashCode()] = student
    println(hashMap[student.hashCode()])



    val generic = Generic(100, "")
    println(generic.name::class.simpleName)
}









