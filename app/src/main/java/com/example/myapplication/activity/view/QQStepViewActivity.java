package com.example.myapplication.activity.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.weight.QQStepView;

public class QQStepViewActivity extends BaseActivity {
    private QQStepView qqStepView;

    public static void start(Context context){
         Intent intent=new Intent(context,QQStepViewActivity.class);
         context.startActivity(intent);
     }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_qq_step;
    }

    @Override
    protected void initData() {
        qqStepView=findViewById(R.id.step_view);
        Button start = findViewById(R.id.start);
        qqStepView.setStepMax(10000);
        final ValueAnimator valueAnimator = ObjectAnimator.ofFloat(0, 9000);
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                qqStepView.setCurrentStep((int)value);
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueAnimator.start();
            }
        });

    }
}
