package com.example.myapplication.base;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Toast;


public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity implements BaseView {
    public Context context;
    protected P mPresenter;
    protected Dialog mLoadingDialog;

    protected abstract P createPresenter();

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void getData();
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(getLayoutId());
//
//        unbinder = ButterKnife.bind(this);
//    }

    @Override
    protected int setLayoutResourceID() {
        return getLayoutId();
    }

    @Override
    protected void initData() {
        context = this;
        mPresenter = createPresenter();
        initView();
        getData();
        mFailedRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }


    /**
     * @param s
     */
    public void showtoast(String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }


    private void closeLoadingDialog() {
        mLoading.setVisibility(View.GONE);
    }

    private void showTokenDialog(String tips) {

    }

    private void showLoadingDialog() {
        mLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMsg(String msg) {
        if (msg.equals("登录失效!")) {
            showTokenDialog(msg);
        } else {
            closeLoadingDialog();
            showtoast(msg);

        }

    }

    @Override
    public void showLoading() {
        showLoadingDialog();
    }


    @Override
    public void hideLoading() {
        closeLoadingDialog();
        if (mFailedView != null) {
            mFailedView.setVisibility(View.GONE);
        }
    }


    @Override
    public void showError(String code, String msg) {
        if (code.equals("0000")) {
            closeLoadingDialog();
            showTokenDialog(msg);
        } else {
            closeLoadingDialog();
            showtoast(msg);
            if (mFailedView != null) {
                mFailedView.setVisibility(View.VISIBLE);
            }
        }


    }

    @Override
    public void onErrorCode(BaseModelNew model) {

    }


}
