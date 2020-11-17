package com.example.myapplication.activity.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseNewActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import butterknife.BindView;
import butterknife.OnClick;

@SuppressLint({"NonConstantResourceId", "SetTextI18n","HandlerLeak"})

public class DaiLogActivity extends BaseNewActivity {
    @BindView(R.id.activity_dialog_btn_show)
    Button button;
    @BindView(R.id.btn1)
    Button button1;
    @BindView(R.id.text1)
    TextView textView;
    @BindView(R.id.activity_dialog_btn2)
    Button button2;
    @BindView(R.id.activity_dialog_btn3)
    Button button3;
    @BindView(R.id.activity_dialog_btn4)
    Button button4;

    private int num = 1;
    private final Handler handler = new Handler();
    private final int[] numbers = new int[]{1, 5, 3, 6, 2, 9, 7, 8, 4};


    public static void start(Context context) {
        Intent intent = new Intent(context, DaiLogActivity.class);
        context.startActivity(intent);
    }


    @OnClick({R.id.activity_dialog_btn_show, R.id.btn1, R.id.activity_dialog_btn2, R.id.activity_dialog_btn3, R.id.activity_dialog_btn4})
    protected void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_dialog_btn_show:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        num += 1;
                        //Log.e("数据1",num+"");
                        handler.postDelayed(this, 1000);
                        textView.setText(num + "");
                    }
                }).start();
//                CommonDialog dialog = new CommonDialog(this);
//                dialog.setMessage("66666")
//                        .setImageResId(R.mipmap.ic_launcher)
//                        .setTitle(num+"")
//                        .setSingle(true).setOnClickBottomListener(new CommonDialog.OnClickBottomListener() {
//                    @Override
//                    public void onPositiveClick() {
//                        //确定
//                        dialog.dismiss();
//                    }
//
//                    @Override
//                    public void onNegtiveClick() {
//                        dialog.dismiss();
//                    }
//                }).show();

//                DialogUtils.showDialog(this, num+"", "123", new DialogUtils.DialogOnclickListener() {
//                    @Override
//                    public void OnSure() {
//
//                    }
//
//                    @Override
//                    public void onDismiss() {
//
//                    }
//                });
                break;
            case R.id.btn1:
                initAssets();
                break;
            case R.id.activity_dialog_btn2:
                new Thread(() -> handler.post(() -> textView.setText("handler123"))).start();
                break;
            case R.id.activity_dialog_btn3:
                new Thread(() -> {
                    Message message = new Message();
                    message.arg1 = 0;
                    message.obj = "123";
                    handler1.sendMessage(message);
                }).start();
                break;
            case R.id.activity_dialog_btn4:
                getMaoPao();
                break;
        }
    }

    private final Handler handler1 = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.arg1 == 0) {
                Log.e("数据2", msg.obj + "");
            }
        }
    };


    private void getMaoPao() {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        for (int number : numbers) {
            Log.e("数据1", number + "");
        }
    }


    @Override
    protected int initLayout() {
        return R.layout.activity_dailog;
    }

    @Override
    protected void initView() {

    }

    private void initAssets() {
        try {
            InputStream inputStream = getAssets().open("json.txt");
            String jsonData = getString(inputStream);
            JSONObject jsonObject = JSONObject.parseObject(jsonData);
            String result = jsonObject.getString("result");
            JSONObject jsonObject1 = JSONObject.parseObject(result);
            JSONArray jsonArray = jsonObject1.getJSONArray("index");
            for (int i = 0; i < jsonArray.size(); i++) {
                Log.e("数据2", jsonArray.get(i) + "");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getString(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
