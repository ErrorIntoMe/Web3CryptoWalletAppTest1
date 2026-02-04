package domain

import core.AppResult

class LoadScreenUseCase(private val repository: Repository) {

    suspend operator fun invoke(): AppResult<ScreenConfig>{
        return repository.loadScreen()
    }
}