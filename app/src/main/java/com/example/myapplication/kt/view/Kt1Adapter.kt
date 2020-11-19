package com.example.myapplication.kt.view

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.myapplication.R
import kotlinx.android.synthetic.main.item_kt1.view.*

class Kt1Adapter(layoutResId: Int,data: List<String?>?):BaseQuickAdapter<String?,BaseViewHolder?>(layoutResId,data) {

    override fun convert(helper: BaseViewHolder?, item: String?) {

        helper?.setText(R.id.item_kt1_text,"12")
        helper?.addOnClickListener(R.id.item_kt1_text)
    }

}