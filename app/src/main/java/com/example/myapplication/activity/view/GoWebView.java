package com.example.myapplication.activity.view;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class GoWebView extends AppCompatActivity {
    EditText editText;
    Button button, button_Back;
    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_web_view);
        editText = findViewById(R.id.edit_web);
        button = findViewById(R.id.btn_go);
        button_Back = findViewById(R.id.btn_back);
        button_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goBack();// 返回前一个页面
            }
        });
        webView = findViewById(R.id.go_web_view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.setWebViewClient(new WebViewController());
                webView.loadUrl(editText.getText().toString());
            }
        });
    }

    public static class WebViewController extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
