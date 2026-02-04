package core

sealed class AppError(message: String? = null, cause: Throwable? = null): Throwable(message, cause) {
    class Network(cause: Throwable?  = null): AppError("Network Error", cause)
    class Unknown(cause: Throwable?  = null): AppError("Unknown Error", cause)
}