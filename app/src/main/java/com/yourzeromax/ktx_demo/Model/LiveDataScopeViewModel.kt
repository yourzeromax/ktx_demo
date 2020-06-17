package com.yourzeromax.ktx_demo.Model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.delay

//PT5
class LiveDataScopeViewModel : ViewModel() {
    /*********************Old**********************/
    private val liveDataOld = MutableLiveData<String>()

    fun initValue(name: String) {
        liveDataOld.value = name
    }

    /*********************New**********************/
    val liveData = liveData<String> {
        delay(1000L)
        emit("yuzhimou")
    }
}