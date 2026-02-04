package data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import network.dto.PostDto

class ApiService(
    private val client: HttpClient
) {

    suspend fun loadPost(): PostDto {
        return client.get("https://jsonplaceholder.typicode.com/posts/1").body<PostDto>()
    }
}