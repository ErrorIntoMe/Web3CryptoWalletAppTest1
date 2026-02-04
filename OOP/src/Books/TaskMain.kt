package Books

import task.Employee
import task.Task

fun main() {
    val task = Task(200, "Макет", "Новый макет", "Максим", "Выполненно", "Высокий"  )
    val employee = Employee(200, "Rustem")

    task.printTaskInfo()
    employee.addTask(task)

    employee.modifyTaskDetails(100, "Пакет", "Новый пакет")

    employee.updateTaskPriority(100, "Низкий")

}