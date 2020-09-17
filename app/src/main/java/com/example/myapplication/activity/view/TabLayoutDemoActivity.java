package com.example.myapplication.activity.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseNewActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/7
 **/
public class TabLayoutDemoActivity extends BaseNewActivity {
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private ArrayList<String> data = new ArrayList<>();
    private MyAdapter myAdapter;


    public static void start(Context context) {
        Intent intent = new Intent(context, TabLayoutDemoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_tablayout_demo;
    }

    @Override
    protected void initView() {
        initToolbar();
        initTabLayout();
        initRecyclerView();
    }

    private void initTabLayout() {
        for (int i = 0; i < 10; i++) {
            tabLayout.addTab(tabLayout.newTab().setText("卡片" + i));//添加选项
        }
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        addRecyclerViewData(0);
        myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
    }

    private void addRecyclerViewData(int pager) {
        data.removeAll(data);
        for (int i = 0; i < 50; i++) {
            data.add("pager=" + pager + ",第" + i + "个item");
        }
    }

    private void initToolbar() {
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setTitle("toolbar标题");
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(getLayoutInflater().inflate(R.layout.item_layout, parent, false));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.textView);
            }
        }
    }

}
