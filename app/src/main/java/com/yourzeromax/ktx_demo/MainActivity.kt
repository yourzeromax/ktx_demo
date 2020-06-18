package com.yourzeromax.ktx_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.forEach
import com.yourzeromax.ktx_demo.Model.DataViewModel
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.*
import com.yourzeromax.ktx_demo.Model.LiveDataScopeViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

//    //PT1-Old
//    private val viewModelBefore: DataViewModel =
//        ViewModelProvider(this).get(DataViewModel::class.java)
//
//    //PT1-New
//    /**
//     * 确保ViewModel在安全的时级创建
//     */
//    private val viewModelAfter by viewModels<DataViewModel>()
//    private val viewModelAfter2: DataViewModel = ViewModelProvider(this).get()

    private val liveDataViewModel = LiveDataScopeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super<AppCompatActivity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_click.setOnClickListener {
            liveDataViewModel.liveData.observe(this){
                Log.d("zzzzz", it)
            }
        }
    }
}