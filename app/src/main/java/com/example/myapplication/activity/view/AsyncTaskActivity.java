package com.example.myapplication.activity.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseNewActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/8
 **/
public class AsyncTaskActivity extends BaseNewActivity {

    @BindView(R.id.edit_async)
    EditText editText;
    @BindView(R.id.async_btn)
    Button button;
    @BindView(R.id.async_text)
    TextView async_text;

    public static void start(Context context) {
        Intent intent = new Intent(context, AsyncTaskActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_async_task;
    }


    @OnClick({R.id.async_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.async_btn:
                int time = Integer.parseInt(editText.getText().toString());
                new MyTask().execute(time);
                break;
        }
    }

    @Override
    protected void initView() {

    }

    /*
     * Params:启动任务执行的输入参数
     * Progress:后台任务执行的百分比
     * Result:后台执行任务最终返回的结果
     * */
    @SuppressLint("StaticFieldLeak")
    class MyTask extends AsyncTask<Integer, Integer, String> {
        /*
         * 执行 线程任务前的操作
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /*
         * 接受输入参数，执行任务中的好事操作，返回线程执行的结果
         * */
        @Override
        protected String doInBackground(Integer... integers) {
            for (int i = integers[0]; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return "计时结束";
        }

        /*
         * 在主线程 显示线程任务执行的进度
         * */
        @SuppressLint("SetTextI18n")
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            async_text.setText(values[0] + "");

        }

        /*
         * 接受线程任务执行结果，讲执行结果显示到UI组件
         * */
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            async_text.setText(s);
        }
    }
}
