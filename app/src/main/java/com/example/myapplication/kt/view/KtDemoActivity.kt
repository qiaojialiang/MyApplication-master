package com.example.myapplication.kt.view

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.example.myapplication.R

/**
 * Created by QiaoJiaLiang
 * Created on 2020/8/25
 **/
class KtDemoActivity : BaseKtActivity(), View.OnClickListener {

    //  @BindView(R.id.text123)
    // internal var textView: TextView? = null

    private var recyclerView: RecyclerView? = null
    //private String a="a";
    private var a: String = "a"
    //private String b;
    private var b: String? = null

    override val setLayoutResourceID: Int
        get() {
            return R.layout.kt_demo
        }

    override fun initView(view: View) {
       // textView!!.setOnClickListener { showToast("123") }
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
        }
    }

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, KtDemoActivity::class.java)
            context.startActivity(intent)
        }
    }
}