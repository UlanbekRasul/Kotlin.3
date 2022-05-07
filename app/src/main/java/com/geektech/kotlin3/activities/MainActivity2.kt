package com.geektech.kotlin3.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import com.geektech.kotlin3.R
import com.geektech.kotlin3.adapters.AdapterSecond
import com.geektech.kotlin3.base.BaseActivity
import com.geektech.kotlin3.databinding.ActivityMain2Binding

class MainActivity2 : BaseActivity<ActivityMain2Binding>() {

    private  lateinit var adapter: AdapterSecond
    private  var listImage = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
    }


    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMain2Binding {
        return ActivityMain2Binding.inflate(inflater)
    }
    private fun initAdapter() {
        adapter = AdapterSecond()
        binding.rv.adapter= adapter
        adapter.setList(listImage)
    }

    override fun initView() {
        super.initView()
        binding.rv.layoutManager= GridLayoutManager(this, 3)
        listImage = intent.getIntegerArrayListExtra("list")!!

    }

}