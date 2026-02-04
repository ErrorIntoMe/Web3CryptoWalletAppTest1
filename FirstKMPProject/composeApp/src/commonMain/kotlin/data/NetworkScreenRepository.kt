package data

import core.AppError
import core.AppResult
import core.safeCall
import domain.Repository
import domain.ScreenConfig
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import kotlinx.serialization.SerializationException

class NetworkScreenRepository(
    private val apiService: ApiService
) : Repository {


    override suspend fun loadScreen(): AppResult<ScreenConfig> {
        return safeCall {
            val dto = apiService.loadPost()
            dto.toScreenConfig()
        }.mapError()
    }


    private fun <T> AppResult<T>.mapError(): AppResult<T> {
        return when (this) {
            is AppResult.Error -> {
                val mapped = when (val cause = error.cause) {
                    is ClientRequestException,
                    is ServerResponseException -> AppError.Network(cause)

                    is SerializationException -> AppError.Unknown(cause)
                    else -> AppError.Unknown(cause)
                }
                AppResult.Error(mapped)
            }

            is AppResult.Success<*> -> this
        }
    }
}