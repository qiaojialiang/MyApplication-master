package com.example.myapplication.activity.view;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MyWebWiewActivity extends AppCompatActivity {
    WebView webView;
    String dataUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web_view);
        Bundle bundle = getIntent().getExtras();
        dataUrl = bundle.getString("dataUrl");
        initData();

    }

    private void initData() {
        webView = findViewById(R.id.my_webview);
        webView.setWebViewClient(new WebViewController());
        webView.loadUrl("http://www.baidu.com");
    }

    public class WebViewController extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
