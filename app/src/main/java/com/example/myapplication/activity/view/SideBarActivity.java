package com.example.myapplication.activity.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.SideBarAdapter;
import com.example.myapplication.base.BaseNewActivity;
import com.example.myapplication.utils.SideBar;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/8
 * 字母索引
 **/
@SuppressLint("NonConstantResourceId")
public class SideBarActivity extends BaseNewActivity {

    @BindView(R.id.side_bar_recycle)
    RecyclerView mRecycleView;
    @BindView(R.id.activity_side_bar_dialog)
    TextView activity_side_bar_dialog;
    @BindView(R.id.side_bar)
    SideBar side_bar;
    private SideBarAdapter mAdapter;
    public String[] name = {"啊", "把", "才", "的", "饿", "发", "个", "花", "I",
            "就", "坑", "了", "吗", "你", "哦", "拍", "钱", "人", "是", "她", "u", "V", "我", "下", "有", "在", "#"};
    public static String[] PINYIN = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z", "#"};
    private List<String> listData = Arrays.asList(name);
    private List<String> pinyin = Arrays.asList(PINYIN);

    public static void start(Context context) {
        Intent intent = new Intent(context, SideBarActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_side_bar;
    }

    @Override
    protected void initView() {
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SideBarAdapter(R.layout.item_side_list, pinyin);
        mRecycleView.setAdapter(mAdapter);
        side_bar.setTextView(activity_side_bar_dialog);
        side_bar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                int pos = 0;
                for (int i = 0; i < PINYIN.length; i++) {
                    if (s.equals(PINYIN[i])) {
                        pos = PinYinChangePosition(PINYIN[i] + "");
                    }
                }
                LinearLayoutManager mLayoutManager = (LinearLayoutManager) mRecycleView.getLayoutManager();
                mLayoutManager.scrollToPositionWithOffset(pos, 0);
            }
        });
    }


    private int PinYinChangePosition(String pinyi) {
        if (pinyi.equals("A")) {
            return 0;
        } else if (pinyi.equals("B")) {
            return 1;
        } else if (pinyi.equals("C")) {
            return 2;
        } else if (pinyi.equals("D")) {
            return 3;
        } else if (pinyi.equals("E")) {
            return 4;
        } else if (pinyi.equals("F")) {
            return 5;
        } else if (pinyi.equals("G")) {
            return 6;
        } else if (pinyi.equals("H")) {
            return 7;
        } else if (pinyi.equals("I")) {
            return 8;
        } else if (pinyi.equals("J")) {
            return 9;
        } else if (pinyi.equals("K")) {
            return 10;
        } else if (pinyi.equals("L")) {
            return 11;
        } else if (pinyi.equals("M")) {
            return 12;
        } else if (pinyi.equals("N")) {
            return 13;
        } else if (pinyi.equals("O")) {
            return 14;
        } else if (pinyi.equals("P")) {
            return 15;
        } else if (pinyi.equals("Q")) {
            return 16;
        } else if (pinyi.equals("R")) {
            return 17;
        } else if (pinyi.equals("S")) {
            return 18;
        } else if (pinyi.equals("T")) {
            return 19;
        } else if (pinyi.equals("U")) {
            return 20;
        } else if (pinyi.equals("V")) {
            return 21;
        } else if (pinyi.equals("W")) {
            return 22;
        } else if (pinyi.equals("X")) {
            return 23;
        } else if (pinyi.equals("Y")) {
            return 24;
        } else if (pinyi.equals("Z")) {
            return 25;
        }
        return -1;
    }
}
