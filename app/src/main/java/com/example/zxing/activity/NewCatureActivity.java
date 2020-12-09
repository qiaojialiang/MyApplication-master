package com.example.zxing.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.zxing.decoding.RGBLuminanceSource;
import com.example.zxing.util.BitmapUtil;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;

import java.util.Hashtable;

public class NewCatureActivity extends AppCompatActivity  {
    Button button ,button1;
    private static final int REQUEST_CODE_SCAN_GALLERY = 100;
    private Bitmap scanBitmap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo);
        button = findViewById(R.id.demo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent innerIntent = new Intent(Intent.ACTION_GET_CONTENT); //"android.intent.action.GET_CONTENT"
                innerIntent.setType("image/*");
                startActivityForResult(innerIntent, REQUEST_CODE_SCAN_GALLERY);
            }
        });
    }

    @Override
    protected void onActivityResult(final int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_SCAN_GALLERY:
                    handleAlbumPic(data);
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void handleAlbumPic(Intent data) {
        final Uri uri = data.getData();
        Log.e("数据1",uri.toString());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Result result = scanningImage(uri);
            }
        });
    }


    public Result scanningImage(Uri uri) {
        if (uri == null) {
            return null;
        }
        Hashtable<DecodeHintType, String> hints = new Hashtable<>();
        hints.put(DecodeHintType.CHARACTER_SET, "UTF8"); //设置二维码内容的编码
        scanBitmap = BitmapUtil.decodeUri(this, uri, 500, 500);
        RGBLuminanceSource source = new RGBLuminanceSource(scanBitmap);
        BinaryBitmap bitmap1 = new BinaryBitmap(new HybridBinarizer(source));
        QRCodeReader reader = new QRCodeReader();
        try {
            return reader.decode(bitmap1, hints);
        } catch (NotFoundException | ChecksumException | FormatException e) {
            e.printStackTrace();
        }
        return null;
    }

}
