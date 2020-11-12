package com.example.myapplication.weight;

import android.content.Context;

import com.example.myapplication.R;

public class DialogUtils {

    public static void showDialog(Context context, String msg, String title,DialogOnclickListener listener) {
        final CommonDialog dialog = new CommonDialog(context);
        dialog.setMessage(msg)
                .setImageResId(R.mipmap.ic_launcher)
                .setTitle(title)
                .setSingle(true).setOnClickBottomListener(new CommonDialog.OnClickBottomListener() {
            @Override
            public void onPositiveClick() {
                //确定
                dialog.dismiss();
                listener.OnSure();

            }

            @Override
            public void onNegtiveClick() {
                dialog.dismiss();
                listener.onDismiss();
            }
        }).show();
    }


    public interface DialogOnclickListener {

        void OnSure();

        void onDismiss();

    }

}
