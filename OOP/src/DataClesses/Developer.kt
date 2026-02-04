package DataClesses

data class Developer(
    override val id: Int,
    override val name: String,
    override val role: String,
    val primaryLanguage: String
) : TeamMember(id, name, role) {
}