package com.example.myapplication.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;
import com.example.myapplication.utils.ActivityManager;
import com.example.myapplication.utils.CustomDialog;
import com.example.myapplication.utils.HttpUtils;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressLint("NonConstantResourceId")
public abstract class BaseActivity extends AppCompatActivity {
    protected Unbinder mUnbinderr;
    @BindView(R.id.activity_base_toolBar)
    protected Toolbar mToolBar;
    protected FrameLayout ll;
    //    @BindView(R.id.activity_base_appBarLayout)
//    protected AppBarLayout mAppBarLayout;
    @BindView(R.id.activity_base_rightImg)
    protected ImageView mRightImg;
    @BindView(R.id.activity_base_rightButton)
    protected Button mRightButton;
    @BindView(R.id.activity_base_back)
    protected ImageView mBackImg;
    @BindView(R.id.activity_base_centerTitle)
    protected TextView mCenterTtile;
    @BindView(R.id.activity_base_rightTitle)
    protected TextView mRightTitle;
    @BindView(R.id.activity_base_view)
    protected View mStatusView;
    @BindView(R.id.activity_base_failed)
    protected View mFailedView;//加载错误布局
    @BindView(R.id.default_failed_retry)
    protected Button mFailedRetry;//错误重试
    @BindView(R.id.activity_base_loading)
    protected View mLoading;//loading
    private WeakReference<Activity> weakReference = null;
    private CustomDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_base);
        ll = findViewById(R.id.swipe_base_layout);
        View realLayout = LayoutInflater.from(this).inflate(setLayoutResourceID(), null, false);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        realLayout.setLayoutParams(params);
        ll.addView(realLayout);
        mUnbinderr = ButterKnife.bind(this);
        //  setSupportActionBar(mToolBar);
        if (useAppBar()) {
            mToolBar.setVisibility(View.VISIBLE);
            mStatusView.setVisibility(View.VISIBLE);
        } else {
            mToolBar.setVisibility(View.GONE);
            mStatusView.setVisibility(View.GONE);
        }
        if (setCenterTitleText() != 0) mCenterTtile.setText(setCenterTitleText());
        if (setRightTitleText() != 0) mRightTitle.setText(setRightTitleText());
        if (setRightImg() != 0) {
            mRightImg.setVisibility(View.VISIBLE);
            mRightImg.setImageResource(setRightImg());
        }
        mBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        initData();
        if (weakReference == null) {
            weakReference = new WeakReference<>(this);
        }
        ActivityManager.getInstance().addActivity(weakReference.get());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinderr != null) {
            mUnbinderr.unbind();
        }
        ActivityManager.getInstance().removeActivity(weakReference.get());
    }

    protected abstract @LayoutRes
    int setLayoutResourceID();

    protected abstract void initData();

    protected boolean useAppBar() {
        return false;
    }

    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return useAppBar();
    }

    /**
     * 获取中间标题
     */
    protected @StringRes
    int setCenterTitleText() {
        return 0;
    }

    protected String getCenterTitleText() {
        return "";
    }


    /**
     * 获取右边标题
     */
    protected @StringRes
    int setRightTitleText() {
        return 0;
    }


    /**
     * 获取右边图标
     *
     * @return
     */
    protected @DrawableRes
    int setRightImg() {
        return 0;
    }


    @SuppressLint("ObsoleteSdkInt")
    @Override
    protected void onStart() {
        super.onStart();
        Window window = getWindow();
        View decorView = window.getDecorView();
        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
