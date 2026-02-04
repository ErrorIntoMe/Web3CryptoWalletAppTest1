package core

import domain.LoadScreenUseCase
import domain.ScreenConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class ShareApi(private val useCase: LoadScreenUseCase) {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    //Android Friendly
    suspend fun loadScreen(): AppResult<ScreenConfig>{
        return  useCase()
    }


    //IOS Friendly
    fun loadScreen(callback: (AppResult<ScreenConfig>) -> Unit){
        scope.launch {
            val result = useCase()
            callback(result)
        }
    }
}