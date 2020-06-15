package com.yourzeromax.ktx_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.forEach
import com.yourzeromax.ktx_demo.Model.DataViewModel
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    //PT1-A
    private val viewModelBefore: DataViewModel = ViewModelProvider(this).get(DataViewModel::class.java)
    //PT1-B
    private val viewModelAfter by viewModels<DataViewModel>()
    private val viewModelAfter2: DataViewModel = ViewModelProvider(this).get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //PT2
        base_group.forEach { }

        //PT3-A
        viewModelAfter.nameLiveData.observe(this, Observer { name ->
            Toast.makeText(this, name, Toast.LENGTH_LONG).show()
        })
        //PT3-B
        viewModelAfter.nameLiveData.observe(this) { name ->
            Toast.makeText(this, name, Toast.LENGTH_LONG).show()
        }

        //PT5
        val viewModel: DataViewModel = ViewModelProvider(this).get()
        val viewModel2: DataViewModel = ViewModelProvider(this).get(DataViewModel::class.java)

        //PT6
        lifecycleScope.launchWhenCreated {  }
        lifecycleScope.launchWhenStarted {  }
        lifecycleScope.launchWhenResumed {  }
        lifecycleScope.launch {
            //PT7
            lifecycle.whenCreated {  }
            lifecycle.whenStarted {  }
            lifecycle.whenResumed {  }
        }

    }
}