package task

import kotlin.String

class Task(
    val id: Int,
    val title: String,
    val description: String,
    val assignedTo: String,
    val status: String,
    val priority: String
) {

    fun copy(
        newStatus: String = this.status,
        newAssignee: String = this.assignedTo,
        newPriority: String = this.priority,
        newTitle: String = this.title,
        newDescription: String = this.description
    ): Task {
        return Task(
            this.id,
            newTitle,
            newDescription,
            newAssignee,
            newStatus,
            newPriority
        )
    }

    fun printTaskInfo() {
        println("Задача #$id: $title")
        println("Описание: $description")
        println("Назначена: $assignedTo")
        println("Статус: $status")
        println("Приоритет: $priority")
        println()
    }
}