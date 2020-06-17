package com.yourzeromax.ktx_demo.Model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

//PT2：viewModelScope的使用能够减少模板代码
class ViewModelScopeViewModel : ViewModel(), CoroutineScope {

    /*********************Old**********************/
    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    fun loadDataOld() {
        launch {
            sortDataList()
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }


    /*********************New**********************/
    /**
     * 没法在主线程完成的繁重操作
     */
    fun loadDataNew() {
        viewModelScope.launch {
            sortDataList()
            // 更新 UI
        }
    }

    /*********************Public methods**********************/
    private suspend fun sortDataList() = withContext(Dispatchers.Default) {
        //模拟获取数据
        delay(1000L)
    }
}