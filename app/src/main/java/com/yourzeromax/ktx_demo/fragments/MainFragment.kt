package com.yourzeromax.ktx_demo.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.createViewModelLazy
import androidx.fragment.app.viewModels
import com.yourzeromax.ktx_demo.Model.DataViewModel

//PT1-Fragment
class MainFragment : Fragment() {
    //不要在onAttach之前调用
    val viewModelFromActivity by activityViewModels<DataViewModel>()

    val viewModelFromFragment by viewModels<DataViewModel>()
    val viewModel by createViewModelLazy(DataViewModel::class, { this.viewModelStore })
}