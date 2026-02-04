package UserList

enum class EnumUserList(val title: String) {
    SHOW("Вывести текущий список в консоль."),
    ADD("Добавить новый элемент"),
    REMOVE("Удалить нужный элемент по названию"),
    REMOVE_AT("Удалить нужный элемент по индексу")
}