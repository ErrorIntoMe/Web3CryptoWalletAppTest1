package task

class Employee(val id: Int, val name: String) {
    private var _tasks = mutableListOf<Task>()
    private var _archivedTasks = mutableListOf<Task>() // TODO: Реализовать функциональность архивирования задач
    val tasks
        get() = _tasks
    val archivedTasks
        get() = _archivedTasks



    fun addTask(task: Task) {
        _tasks.add(task)
        println("Добавлена задача: ${task.title} для сотрудника $name.")
    }

    fun removeTask(taskId: Int) {
        val task = _tasks.find { it.id == taskId }
        if (task != null) {
            _tasks.remove(task)
            println("Задача ${task.title} удалена.")
        } else {
            println("Задача с ID $taskId не найдена.")
        }
    }

    fun updateTaskStatus(taskId: Int, newStatus: String) {
        val task = _tasks.find { it.id == taskId }
        if (task != null) {
            val newTask = task.copy(newStatus = newStatus)
            _tasks[_tasks.indexOf(task)] = newTask
            println("Статус задачи ${task.title} изменен на '$newStatus'.")
        } else {
            println("Задача с ID $taskId не найдена.")
        }
    }

    fun changeTaskAssignee(taskId: Int, newAssignee: String) {
        val task = _tasks.find { it.id == taskId }
        if (task != null) {
            val newTask = task.copy(newAssignee = newAssignee)
            _tasks[_tasks.indexOf(task)] = newTask
            println("Задача ${task.title} переназначена на $newAssignee.")
        } else {
            println("Задача с ID $taskId не найдена.")
        }
    }

    fun updateTaskPriority(taskId: Int, newPriority: String) {
        var task = _tasks.find { it.id == taskId }
        if (task != null) {
           val newTask =  task.copy(newPriority = newPriority)
            _tasks[_tasks.indexOf(task)] = newTask
            println("Приоритет задачи ${task.title} изменен на '$newPriority'.")
        } else {
            println("Задача с ID $taskId не найдена.")
        }
    }

    fun modifyTaskDetails(taskId: Int, newTitle: String, newDescription: String) {
        val task = _tasks.find { it.id == taskId }
        if (task != null) {
            val newTask = task.copy(newTitle = newTitle, newDescription = newDescription)
            _tasks[_tasks.indexOf(task)] = newTask
            println("Детали задачи ${task.id} обновлены.")
        } else {
            println("Задача с ID $taskId не найдена.")
        }
    }

    fun printTasks() {
        println("Список задач для сотрудника $name:")
        _tasks.forEach { it.printTaskInfo() }
    }
}
