package com.yourzeromax.ktx_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.*
import com.yourzeromax.ktx_demo.fragments.MainFragment
import kotlinx.android.synthetic.main.activity_fragment_ktx.*
import kotlinx.android.synthetic.main.activity_main.*

class FragmentKtxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_ktx)
    }


    //PT6-findFragmentKtx
    private fun findFramgentKtx() {
        //获取View对应的Fragment
        base_group.findFragment<MainFragment>()
    }


    //PT6-commitKtx
    private fun commitKtx() {
        //简化commit流程
        /*********************Old**********************/
        supportFragmentManager.beginTransaction().add(MainFragment(), "mainFragment").commit()
        /*********************new**********************/
        supportFragmentManager.commit {
            this.add(MainFragment(), "mainFragment")
        }
    }


    //PT6-addKtx，简化add
    private fun addKtx(fragmentManager: FragmentManager) {
        /*********************Old**********************/
        val bundle1 = Bundle()
        bundle1.putString("app_name", "demo")
        val fragment = MainFragment()
        fragment.arguments = bundle1
        fragmentManager.beginTransaction().add(fragment,"MainFragment").commit()


        /*********************new**********************/
        val bundle2 = Bundle()
        bundle2.putString("app_name", "demo")
        fragmentManager.beginTransaction().add<MainFragment>("MainFragment", bundle2).commit()
        fragmentManager.beginTransaction().add<MainFragment>(R.id.container,"MainFragment").commit()
        fragmentManager.beginTransaction().replace<MainFragment>(R.id.container,"tag",Bundle()).commit()
    }
}