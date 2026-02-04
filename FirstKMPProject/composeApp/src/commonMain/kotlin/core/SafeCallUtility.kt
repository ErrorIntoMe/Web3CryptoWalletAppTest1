package core

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import kotlinx.serialization.SerializationException

suspend fun <T> safeCall(block: suspend () -> T): AppResult<T> {
    return try {
        AppResult.Success(block())
    } catch (e: Throwable) {
        val error = when (e) {
            is ClientRequestException,
            is ServerResponseException -> AppError.Network(e)

            is SerializationException -> AppError.Unknown(e)
            else -> AppError.Unknown(e)
        }
        AppResult.Error(AppError.Unknown(e))
    }
}