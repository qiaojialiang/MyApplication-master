package com.example.myapplication.webview;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class BaseWebViewActivity  extends AppCompatActivity {
    protected WebView webView;
    protected WebChromeClient chromeClient;
    protected WebViewClient webViewClient;
    protected ProgressBar progressBar;
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

    }



}
