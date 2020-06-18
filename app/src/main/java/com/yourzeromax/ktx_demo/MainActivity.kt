package com.yourzeromax.ktx_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.forEach
import androidx.fragment.app.*
import com.yourzeromax.ktx_demo.Model.DataViewModel
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.*
import com.yourzeromax.ktx_demo.Model.LiveDataScopeViewModel
import com.yourzeromax.ktx_demo.fragments.MainFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {


    //PT1-Old
    private val viewModelBefore: DataViewModel =
        ViewModelProvider(this).get(DataViewModel::class.java)

    //PT1-New
    /**
     * 确保ViewModel在安全的时级创建
     */
    private val viewModelAfter by viewModels<DataViewModel>()
    private val viewModelAfter2: DataViewModel = ViewModelProvider(this).get()

    private val liveDataViewModel = LiveDataScopeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super<AppCompatActivity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_click.setOnClickListener {
            val liveData = liveDataViewModel.liveDataOld
            liveData.observe(this) {
                Log.d("zzzzz", it)
            }
            liveDataViewModel.initValue()
        }
    }

    //PT5  extension
   fun initLiveDataOld(){
        val liveData = liveDataViewModel.liveDataOld
        liveData.observe(this) {
            Log.d("zzzzz", it)
        }
        liveDataViewModel.initValue()
    }

}