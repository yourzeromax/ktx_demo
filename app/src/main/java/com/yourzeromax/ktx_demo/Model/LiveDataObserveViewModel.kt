package com.yourzeromax.ktx_demo.Model

import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.*

//PT3: 简化LiveData.Observe的模板代码
class LiveDataObserveViewModel : ViewModel() {
    val liveData: LiveData<String> = MutableLiveData()


    /*********************Old**********************/
    private fun registerObserveOld(owner: LifecycleOwner) {
        liveData.observe(owner, Observer { name ->
            // Toast.makeText(this, name, Toast.LENGTH_LONG).show()
        })
    }


    /*********************New**********************/
    private fun registerObserveNew(owner: LifecycleOwner) {
        liveData.observe(owner) {
            // Toast.makeText(this, name, Toast.LENGTH_LONG).show()
        }
    }
}