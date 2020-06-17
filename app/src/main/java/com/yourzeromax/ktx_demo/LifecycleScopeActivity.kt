package com.yourzeromax.ktx_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

//PT4：消除模板代码
class LifecycleScopeActivity : AppCompatActivity(), DefaultLifecycleObserver, CoroutineScope {
    /*********************Old**********************/
    val job = SupervisorJob()
    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super<AppCompatActivity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_scope)
        lifecycle.addObserver(this)
    }

    //需要自己去管理
    override fun onDestroy() {
        super<AppCompatActivity>.onDestroy()
        coroutineContext.cancel()
    }

    override fun onCreate(owner: LifecycleOwner) {
        launch {

        }
    }

    override fun onPause(owner: LifecycleOwner) {
        launch {

        }
    }

    override fun onDestroy(owner: LifecycleOwner) {
        launch {

        }
    }

    override fun onStart(owner: LifecycleOwner) {
        launch {

        }
    }

    override fun onResume(owner: LifecycleOwner) {
        launch {

        }
    }

    override fun onStop(owner: LifecycleOwner) {
        launch {

        }
    }


    /*********************New**********************/
    /**
     * 优点：This scope will be cancelled when the [Lifecycle] is destroyed.
     */
    private fun lifecycleScopeNew() {
        lifecycleScope.launchWhenCreated { }
        lifecycleScope.launchWhenStarted { }
        lifecycleScope.launchWhenResumed { }
        lifecycleScope.launch {
            lifecycle.whenCreated { }
            lifecycle.whenStarted { }
            lifecycle.whenResumed { }
        }
    }
}