package DataClesses

data class ProjectManager(
 override val  id: Int,
   override val name: String,
   override val role: String,
    val projectsHandled: Int
) : TeamMember(id, name, role) {
}