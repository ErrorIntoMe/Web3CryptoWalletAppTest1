package domain

import core.AppResult

interface Repository {

    suspend fun loadScreen(): AppResult<ScreenConfig>
}