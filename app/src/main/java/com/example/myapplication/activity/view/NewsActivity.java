package com.example.myapplication.activity.view;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.example.myapplication.R;
import com.example.myapplication.adapter.MyPagetAdapter1;
import com.example.myapplication.base.BaseActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class NewsActivity extends BaseActivity {
    private XTabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> fragmentList = new ArrayList<>();
    private String[] titleList = new String[]{"头条", "体育", "娱乐", "军事"};
    private List<String> stringList = new ArrayList<>();

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_news;
    }


    @Override
    protected void initData() {
        initView();
    }

    private void initView() {
        mTabLayout = findViewById(R.id.xTablayout);
        mViewPager = findViewById(R.id.view_pager);
        for (int i = 0; i < titleList.length; i++) {
            stringList.add(titleList[i]);
            fragmentList.add(new NewsFragment());
        }
        mViewPager.setAdapter(new MyPagetAdapter1(getSupportFragmentManager(), NewsActivity.this, fragmentList, stringList));
        mTabLayout.setupWithViewPager(mViewPager);
    }


    public void getString() throws IOException {
        InputStream inputStream = getAssets().open("json.txt");
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuffer sb = new StringBuffer("");
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            content = sb.toString();
        }
    }
}
