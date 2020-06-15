package com.yourzeromax.ktx_demo.Model

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class DataViewModel : ViewModel() {


    /**
     * 没法在主线程完成的繁重操作
     */
    fun loadData() {
        viewModelScope.launch {
            sortList()
            // 更新 UI
        }
    }

    suspend fun sortList() = withContext(Dispatchers.Default) {
        delay(1000L)
    }

    init {
        //PT8
        viewModelScope.launch { }
    }

    val nameLiveData: LiveData<String> = MutableLiveData()

    //PT4
    val testLiveData: LiveData<String> = liveData(Dispatchers.IO,3000) {
        delay(1000L)
        //确保在context+Dispatchers.main中调用
        emit("yuzhimou")
    }


}