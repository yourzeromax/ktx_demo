package com.yourzeromax.ktx_demo.Model

import androidx.lifecycle.*
import com.yourzeromax.ktx_demo.data.User
import kotlinx.coroutines.delay

//PT5
class LiveDataScopeViewModel : ViewModel() {
    /*********************Old**********************/
    private val liveDataOld = MutableLiveData<String>()

    fun initValue(name: String) {
        liveDataOld.value = name
    }

    /*********************New**********************/
    /**
     * 被观察对象在首次注册Observer的时候（onActive），延迟初始化自身的值
     */
    val liveData = liveData<String> {
        val data = getData()
        emit(data)
    }


    /**
     * 每隔30s就根据当前user的数据更新name。
     */
    private val user: LiveData<User> = MutableLiveData<User>()
    val userName:LiveData<String> = user.switchMap { user ->
        liveData {
            while (true) {
                val data = getDataById(user.id)
                emit(data)
                delay(30_000)
            }
        }
    }


    /**
     * 模拟耗时请求
     */
    private suspend fun getData(): String {
        delay(3000L)
        return "yuzhimou"
    }

    private suspend fun getDataById(id:Long):String{
        delay(3000L)
        return "yuzhimou"

    }

}