package com.example.myapplication.kt.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.myapplication.R

@SuppressLint("NonConstantResourceId")
class Kt1 : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    var kt1Adapter: Kt1Adapter? = null
    var list: ArrayList<String?> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kt1)
        initView()
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, Kt1::class.java)
            context.startActivity(intent)
        }
    }

    fun initView() {
        for (i in 1..10) {
            list.add("123")
        }
        recyclerView = findViewById(R.id.kt1_recycle)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        kt1Adapter = Kt1Adapter(R.layout.item_kt1, list)
        recyclerView?.adapter = kt1Adapter
        kt1Adapter?.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
//            when (view.id) {
//                R.id.item_price -> {
//                    if (position == 0) {
//
//                    }
//                }
//            }
        }
    }


//    @OnClick(id.btn_kt1)
//    fun onClick(view: View) {
//        when (view.id) {
//            id.btn_kt1 -> {
//
//
//            }
//        }
//    }
}