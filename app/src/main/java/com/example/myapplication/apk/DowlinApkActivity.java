package com.example.myapplication.apk;

import android.Manifest;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.jxxy.mobileguard.sweetdialog.SweetAlertDialog;
import com.maning.updatelibrary.InstallUtils;


public class DowlinApkActivity extends AppCompatActivity {
    Button button;
    private SweetAlertDialog mUploadingDialog;
    private SweetAlertDialog mSuccessDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apk);
        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {
                    int REQUEST_CODE_CONTACT = 101;
                    String[] permissions = {
                            Manifest.permission.WRITE_EXTERNAL_STORAGE};
                    //验证是否许可权限
                    for (String str : permissions) {
                        if (DowlinApkActivity.this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                            //申请权限
                            DowlinApkActivity.this.requestPermissions(permissions, REQUEST_CODE_CONTACT);
                            return;
                        } else {
                            //这里就是权限打开之后自己要操作的逻辑
                            download();
                        }
                    }
                }
            }
        });
    }

    public void download() {
        String url = "http://cdn.xiaoxiongyouhao.com/apps/androilas.apk";
        String apkName = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
        InstallUtils.with(this)
                .setApkUrl("http://cdn.xiaoxiongyouhao.com/apps/androilas.apk")
                .setApkPath(Environment.getExternalStorageDirectory().getPath() + "/123.apk")
                .setCallBack(new InstallUtils.DownloadCallBack() {
                    @Override
                    public void onStart() {
                        // Log.e("数据2","开始下载");
                        showUploadingDialog();
                    }

                    @Override
                    public void onComplete(String s) {
                        Log.e("数据2", s + "");
                        if (mUploadingDialog.isShowing()) {
                            mUploadingDialog.dismiss();
                        }
                        showSuccessDialog("下载完成Apk文件保存至" + Environment.getExternalStorageDirectory().getPath() + "/123.apk");
                    }

                    @Override
                    public void onLoading(long l, long l1) {
                        int a = (int) l;
                        int b = (int) l1;
                        int c = a / b;
                        int d = 100 - c;
                        Log.e("数据14", 100 - c + "");
                        if (mUploadingDialog.isShowing()) {
                            mUploadingDialog.setContentText(apkName + "Apk下载进度" + d + "%");
                        }
                    }

                    @Override
                    public void onFail(Exception e) {
                        //Log.e("数据2",e.getMessage()+"");
                    }

                    @Override
                    public void cancle() {

                    }
                }).startDownload();

    }

    public SweetAlertDialog showUploadingDialog() {
        mUploadingDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        mUploadingDialog.setContentText("正在下载apk");
        mUploadingDialog.setCanceledOnTouchOutside(false);
        mUploadingDialog.show();
        return mUploadingDialog;
    }

    private void showSuccessDialog(String data) {
        mSuccessDialog = new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE);
        mSuccessDialog.setContentText(data);
        mSuccessDialog.setConfirmText("确定");
        mSuccessDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                mSuccessDialog.cancel();
            }
        });

        mSuccessDialog.setCanceledOnTouchOutside(true);
        mSuccessDialog.show();
        mSuccessDialog.setCancelable(false);
    }
}
