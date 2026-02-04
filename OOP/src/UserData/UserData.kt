package UserData

data class UserData(
    var name: String? = "Unknown Name",
    var email: String? = "Unknown Email",
    var age: Int? = 0

){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserData

        if (age != other.age) return false
        if (name != other.name) return false
        if (email != other.email) return false

        return true
    }

    override fun hashCode(): Int {
        var result = age ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (email?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Name: ${name}, Email: ${email}, Age: ${age}"
    }
}

