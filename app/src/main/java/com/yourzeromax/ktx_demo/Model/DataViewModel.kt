package com.yourzeromax.ktx_demo.Model

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class DataViewModel : ViewModel() {
    val nameLiveData: LiveData<String> = MutableLiveData()
}