package data

import core.AppResult
import core.safeCall
import domain.Repository
import domain.ScreenConfig
import kotlinx.coroutines.delay

class RepositoryImpl : Repository {


    override suspend fun loadScreen(): AppResult<ScreenConfig> = safeCall {
        delay(300)
        ScreenConfig(
            "KMP + BDUI demo",
            "День 2: ошибки + iOS-friendly API "
        )
    }
}