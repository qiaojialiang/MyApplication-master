package com.example.myapplication.activity.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.weight.CustomDialog;
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
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoWebView extends AppCompatActivity implements View.OnClickListener {
    private static EditText editText;
    private ImageView BtnSend, BtnGoBack, BtnHome, BtnRefresh;
    private WebView webView;
    private String url1;
    private ProgressBar progressBar;
    private static TextView text_title;
    LinearLayout line1;
    private TextView prompt;
    private Bitmap scanBitmap;
    private CustomDialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_web_view);
        initView();

    }

    private void initView() {
        editText = findViewById(R.id.editText);
        BtnSend = findViewById(R.id.btn_go);
        BtnGoBack = findViewById(R.id.btn_back);
        webView = findViewById(R.id.web_view);
        text_title = findViewById(R.id.text_title);
        BtnHome = findViewById(R.id.btn_home);
        BtnHome.setOnClickListener(this);
        progressBar = findViewById(R.id.progressBar1);
        line1 = findViewById(R.id.line1);
        prompt = findViewById(R.id.prompt);
        BtnRefresh = findViewById(R.id.btn_refresh);
        Intent intent = getIntent();
        String str = intent.getStringExtra("url");
        String qrStr = intent.getStringExtra("qrurl");
        if (str != null && qrStr == null) {
            //为网址
            boolean status = str.contains("http");
            if (status) {
                url1 = str;
            } else {
                url1 = "http://" + str;
            }
            webView.setVisibility(View.VISIBLE);
            line1.setVisibility(View.VISIBLE);
            editText.setVisibility(View.GONE);
            prompt.setVisibility(View.GONE);
            text_title.setText(url1);
            webView.setWebViewClient(new WebViewController());
            webView.loadUrl(url1);
        } else if (qrStr != null && str == null) {
            //二维码地址
            Uri mediaUriFromPath = Uri.fromFile(new File(qrStr));
            if (mediaUriFromPath != null) {
                handleAlbumPic(mediaUriFromPath);
            }
        } else {
            webView.setVisibility(View.GONE);
            editText.setVisibility(View.VISIBLE);
            line1.setVisibility(View.GONE);
            prompt.setVisibility(View.VISIBLE);

        }
        BtnGoBack.setOnClickListener(this);
        BtnSend.setOnClickListener(this);
        BtnRefresh.setOnClickListener(this);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                webView.goBack();// 返回前一个页面
                myLastUrl();
                break;
            case R.id.btn_go:
                if (!TextUtils.isEmpty(editText.getText().toString())) {
                    webView.setVisibility(View.VISIBLE);
                    editText.setVisibility(View.GONE);
                    line1.setVisibility(View.VISIBLE);
                    prompt.setVisibility(View.GONE);
                    webView.setWebViewClient(new WebViewController());
                    if (editText.getText().toString().contains("http")) {
                        webView.loadUrl(editText.getText().toString());
                    } else {
                        webView.loadUrl("http://" + editText.getText().toString());
                    }
                } else {
                    Toast.makeText(GoWebView.this, "请输入地址", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btn_home:
                text_title.setText("");
                editText.setText("");
                webView.setVisibility(View.GONE);
                editText.setVisibility(View.VISIBLE);
                line1.setVisibility(View.GONE);
                prompt.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
                webView.loadDataWithBaseURL(null, "","text/html", "utf-8",null);
                break;
            case R.id.btn_refresh:
                webView.reload();
                break;
        }
    }

    public static class WebViewController extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            text_title.setText(url);
            return true;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            // super.onReceivedSslError(view, handler, error);
            handler.proceed();
        }
    }

    private void myLastUrl() {
        WebBackForwardList backForwardList = webView.copyBackForwardList();
        if (backForwardList != null && backForwardList.getSize() != 0) {
            int currentIndex = backForwardList.getCurrentIndex();
            WebHistoryItem historyItem =
                    backForwardList.getItemAtIndex(currentIndex - 1);
            if (historyItem != null) {
                String backPageUrl = historyItem.getUrl();
                webView.goBack();
                text_title.setText(backPageUrl);
            }
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            if (!TextUtils.isEmpty(editText.getText().toString())) {
                hideSoftKeyboard(GoWebView.this);
                webView.setVisibility(View.VISIBLE);
                editText.setVisibility(View.GONE);
                line1.setVisibility(View.VISIBLE);
                prompt.setVisibility(View.GONE);
                webView.setWebViewClient(new WebViewController());
                if (editText.getText().toString().contains("http")) {
                    webView.loadUrl(editText.getText().toString());
                } else {
                    webView.loadUrl("http://" + editText.getText().toString());
                }
            } else {
                Toast.makeText(GoWebView.this, "请输入地址", Toast.LENGTH_LONG).show();
            }

            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    public static void hideSoftKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    private void handleAlbumPic(Uri uri) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Result result = scanningImage(uri);
                String QrData = result.getText();
                if (isHttpUrl(QrData)) {
                    //是网址
                    boolean status = QrData.contains("http");
                    if (status) {
                        url1 = QrData;
                    } else {
                        url1 = "http://" + QrData;
                        webView.setVisibility(View.VISIBLE);
                        editText.setVisibility(View.GONE);
                        line1.setVisibility(View.VISIBLE);
                        prompt.setVisibility(View.GONE);
                        webView.setWebViewClient(new WebViewController());
                        webView.loadUrl(url1);
                    }
                } else {
                    //不是
                    mDialog = new CustomDialog(GoWebView.this, QrData,
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mDialog.dismiss();
                                }
                            });
                    mDialog.setCanotBackPress();
                    mDialog.setCanceledOnTouchOutside(false);
                    mDialog.show();
                }
            }
        });
    }

    public static boolean isHttpUrl(String urls) {
        boolean isurl = false;
        String regex = "(((https|http)?://)?([a-z0-9]+[.])|(www.))"
                + "\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z0-9]{0,}+|/?)";//设置正则表达式
        Pattern pat = Pattern.compile(regex.trim());//比对
        Matcher mat = pat.matcher(urls.trim());
        isurl = mat.matches();//判断是否匹配
        if (isurl) {
            isurl = true;
        }
        return isurl;
    }

    public Result scanningImage(Uri uri) {
        if (uri == null) {
            return null;
        }
        Hashtable<DecodeHintType, String> hints = new Hashtable<>();
        hints.put(DecodeHintType.CHARACTER_SET, "UTF8");
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
