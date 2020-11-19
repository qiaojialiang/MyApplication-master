package com.example.myapplication.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.myapplication.R
import kotlinx.android.synthetic.main.item_side_list.view.*

/**
 * Created by QiaoJiaLiang
 * Created on 2020/8/20
 */
class PriceAdapter(layoutResId: Int, data: List<String?>?) : BaseQuickAdapter<String?, BaseViewHolder?>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder?, item: String?) {
    }
}