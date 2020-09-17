package com.example.myapplication.kt.view

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import butterknife.ButterKnife


/**
 * Created by QiaoJiaLiang
 * Created on 2020/8/25
 **/
abstract class BaseKtActivity : AppCompatActivity() {
    private val mContextView: View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutResourceID)
        steepStatusBar()
        ButterKnife.bind(this)
        if (mContextView != null) {
            initView(mContextView)
        }
    }

    protected abstract val setLayoutResourceID: Int

    // public abstract void initView(final View view);
    abstract fun initView(view: View)

    /*
    * 沉浸式状态栏
    * */
    @SuppressLint("ObsoleteSdkInt")
    fun steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }
    }

    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}