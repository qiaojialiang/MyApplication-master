package com.example.myapplication.activity.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseNewActivity;
import com.example.myapplication.weight.CommonDialog;
import com.example.myapplication.weight.DialogUtils;

import butterknife.BindView;
import butterknife.OnClick;

@SuppressLint("NonConstantResourceId")
public class DaiLogActivity extends BaseNewActivity {

    @BindView(R.id.btn_show)
    Button button;
    @BindView(R.id.text1)
    TextView textView;

    private int num=1;

    private final Handler handler = new Handler();

    public static void start(Context context) {
        Intent intent = new Intent(context, DaiLogActivity.class);
        context.startActivity(intent);
    }


    @OnClick({R.id.btn_show})
    protected void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_show:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        num+=1;
                        //Log.e("数据1",num+"");
                        handler.postDelayed(this, 1000);
                        textView.setText(num+"");
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
//
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
        }
    }


    @Override
    protected int initLayout() {
        return R.layout.activity_dailog;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }


}
