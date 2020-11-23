package com.example.myapplication.activity.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseNewActivity;
import com.example.myapplication.bean.WeatherBean;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/9
 * 动画
 **/
@SuppressLint("NonConstantResourceId")
public class AnimatorActivity extends BaseNewActivity {

    @BindView(R.id.btn_alpha)
    Button btn_alpha;
    @BindView(R.id.btn_set)
    Button btn_set;
    @BindView(R.id.btn_translation)
    Button btn_translation;
    @BindView(R.id.btn_rotation)
    Button btn_rotation;
    @BindView(R.id.animator_image)
    ImageView animator_image;


    public static void start(Context context) {
        Intent intent = new Intent(context, AnimatorActivity.class);
        context.startActivity(intent);
    }


    @OnClick({R.id.btn_alpha, R.id.btn_set, R.id.btn_translation, R.id.btn_rotation})
    protected void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_alpha:
                initAlpha();
                break;
            case R.id.btn_set:
                initSet();
                break;
            case R.id.btn_translation:
                initTranslation();
                break;
            case R.id.btn_rotation:
                rotate();
                break;
        }
    }




    @Override
    protected int initLayout() {
        return R.layout.activity_animator;
    }

    @Override
    protected void initView() {

        WeatherBean weatherBean;


    }

    /*
     * 透明度
     * */
    private void initAlpha() {
        ObjectAnimator
                .ofFloat(animator_image, "alpha", 1, 0, 1)
                .setDuration(1000)//设置动画播放持续时间
                .start();
    }
    /*
     * 缩放
     * AnimatorSet用来实现复杂的组合动画
     * */

    private void initSet() {
        final AnimatorSet animatorSet = new AnimatorSet();
        animator_image.setPivotX(animator_image.getWidth() + 50);
        animator_image.setPivotY(animator_image.getHeight() + 50);
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(animator_image, "scaleX", 1, 0, 1).setDuration(2000),
                ObjectAnimator.ofFloat(animator_image, "scaleY", 1, 0, 1).setDuration(2000));
        animatorSet.start();
    }

    /*
     * 平移
     * */
    private void initTranslation() {
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.9f);
        animation.setDuration(2000);
        animation.setRepeatCount(-1);//设置动画重复次数 <0为无线循环
        animation.setRepeatMode(Animation.RESTART);//设置动画重复时候的模式
        animator_image.startAnimation(animation);
    }

    /*
     * 旋转
     * */

    private void rotate() {
        Animation animation = new RotateAnimation(0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(1000);
        animation.setRepeatCount(-1);//动画的重复次数
        animation.setFillAfter(false);//设置为true，动画转化结束后被应用
        animator_image.startAnimation(animation);//开始动画


        // ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(animator_image, "rotation", 360f);
        // objectAnimator.setDuration(1000);
        // objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        // objectAnimator.start();

    }
}
