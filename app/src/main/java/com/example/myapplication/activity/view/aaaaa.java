package com.example.myapplication.activity.view;

import android.app.DownloadManager;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
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

import java.io.File;
import java.net.URI;
import java.util.Hashtable;


public class aaaaa extends AppCompatActivity {

    Bitmap scanBitmap;
    WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aaaaaa_demo);
        webView=findViewById(R.id.demo_web);
        webView.setWebViewClient(new WebViewController());

        webView.loadUrl("https://www.baidu.com");
        webView.setDownloadListener(new MyDownLoadListener(this));
//        File file = new File(getExternalCacheDir() + "/test.png");
//        Glide.with(this).load(file).into(imageView);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent = new Intent();
////                /* 开启Pictures画面Type设定为image */
////                intent.setType("image/*");
////                /* 使用Intent.ACTION_GET_CONTENT这个Action */
////                intent.setAction(Intent.ACTION_GET_CONTENT);
////                /* 取得相片后返回本画面 */
////                startActivityForResult(intent, 1);
//////                Uri uri= Uri.parse(file.toString());
//////                Log.e("数据1",uri.toString()+"");
////
////                Uri uri =Uri.fromFile(file);
////                handleAlbumPic(uri);
////                Log.e("数据1",Uri.fromFile(file)+"");
//            }
//        });

//        Bundle bundle = getIntent().getExtras();
//        String imageurl = bundle.getString("url");
//        Log.e("数据2", imageurl + "");
//        Log.e("数据1", getMediaUriFromPath(this, imageurl)+"");
        //handleAlbumPic(getMediaUriFromPath(this, imageurl));


        //Uri mediaUriFromPath = getMediaUriFromPath(this, "/storage/emulated/0/Pictures/test.png");
                                                                ///storage/emulated/0/test.png
//        Uri mediaUriFromPath= Uri.fromFile(new File("/storage/emulated/0/test.png"));
//        if (mediaUriFromPath != null){
//            Log.d("mediaUriFromPath", "mediaUriFromPath:" + mediaUriFromPath.toString());
//            handleAlbumPic(mediaUriFromPath);
//        }
    }


    public static class MyDownLoadListener implements DownloadListener{
        private Context context;

        public MyDownLoadListener(Context context) {
            this.context = context;
        }

        @Override
        public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
            Log.i("tag", "url="+url);
            Log.i("tag", "userAgent="+userAgent);
            Log.i("tag", "contentDisposition="+contentDisposition);
            Log.i("tag", "mimetype="+mimetype);
            Log.i("tag", "contentLength="+contentLength);
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(intent);
            new DownloadThread(url).start();
        }
    }
//
//    /***
//     * 将指定路径的图片转uri
//     * @param context
//     * @param path ，指定图片(或文件)的路径
//     * @return
//     */
//    public static Uri getMediaUriFromPath(Context context, String path) {
//        Uri mediaUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
//        Cursor cursor = context.getContentResolver().query(mediaUri,
//                null,
//                MediaStore.Images.Media.DISPLAY_NAME + "= ?",
//                new String[]{path.substring(path.lastIndexOf("/") + 1)},
//                null);
//
//        Uri uri = null;
//        if (cursor.moveToFirst()) {
//            uri = ContentUris.withAppendedId(mediaUri,
//                    cursor.getLong(cursor.getColumnIndex(MediaStore.Images.Media._ID)));
//        }
//        cursor.close();
//        return uri;
//    }


//    private void downloadByBrowser(String url) {
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.addCategory(Intent.CATEGORY_BROWSABLE);
//        intent.setData(Uri.parse(url));
//        startActivity(intent);
//    }




    public static class WebViewController extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return true;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            // super.onReceivedSslError(view, handler, error);
            handler.proceed();
        }
    }


    }

//    private void handleAlbumPic(Uri uri) {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                Result result = scanningImage(uri);
//                Log.e("数据", result.getText() + "");
//            }
//        });
//    }


//    public Result scanningImage(Uri uri) {
//        if (uri == null) {
//            return null;
//        }
//        Hashtable<DecodeHintType, String> hints = new Hashtable<>();
//        hints.put(DecodeHintType.CHARACTER_SET, "UTF8"); //设置二维码内容的编码
//        scanBitmap = BitmapUtil.decodeUri(this, uri, 500, 500);
//        RGBLuminanceSource source = new RGBLuminanceSource(scanBitmap);
//        BinaryBitmap bitmap1 = new BinaryBitmap(new HybridBinarizer(source));
//        QRCodeReader reader = new QRCodeReader();
//        try {
//            return reader.decode(bitmap1, hints);
//        } catch (NotFoundException | ChecksumException | FormatException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }