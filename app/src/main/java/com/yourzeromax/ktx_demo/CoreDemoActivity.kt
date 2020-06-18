package com.yourzeromax.ktx_demo

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit

class CoreDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_core_demo)
        val share = getSharedPreferences("awer", Context.MODE_PRIVATE)
        share.edit {  }
    }
}