package com.example.myapplication.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;


import com.example.myapplication.R;

public class QQStepView extends View {

    private int mOuterColor = Color.GRAY;
    private int mInnerColor = Color.RED;
    private float mBorderWidth = 20.0f;//20代表的20px
    private float mStepViewTextSize = 12.0f;
    private int mStepViewTextColor = Color.BLACK;
    private Paint mOutPaint;

    private int mStepMax;//最大的数值
    private int mCurrentStep;//当前的数值
    private Paint mInnerPaint;
    private Paint mTextPaint;

    public QQStepView(Context context) {
        this(context, null);

    }

    public QQStepView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public QQStepView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.QQStepView);
        mOuterColor = array.getColor(R.styleable.QQStepView_outerColor, mOuterColor);
        mInnerColor = array.getColor(R.styleable.QQStepView_innerColor, mInnerColor);
        mBorderWidth = array.getDimension(R.styleable.QQStepView_borderWidth, mBorderWidth);
        mStepViewTextColor = array.getColor(R.styleable.QQStepView_stepViewTextColor, mStepViewTextColor);
        mStepViewTextSize = array.getDimension(R.styleable.QQStepView_stepViewTextSize, mStepViewTextSize);
        array.recycle();
        //外层圆弧画笔
        mOutPaint = new Paint();
        mOutPaint.setAntiAlias(true);
        mOutPaint.setStrokeWidth(mBorderWidth);
        mOutPaint.setColor(mOuterColor);
        mOutPaint.setStrokeCap(Paint.Cap.ROUND);//两端变圆弧
        mOutPaint.setStyle(Paint.Style.STROKE);
        //内层圆弧画笔
        mInnerPaint = new Paint();
        mInnerPaint.setAntiAlias(true);
        mInnerPaint.setStrokeWidth(mBorderWidth);
        mInnerPaint.setColor(mInnerColor);
        mInnerPaint.setStrokeCap(Paint.Cap.ROUND);//两端变圆弧
        mInnerPaint.setStyle(Paint.Style.STROKE);
        //文字画笔
        mTextPaint = new Paint();
        mInnerPaint.setAntiAlias(true);
        mInnerPaint.setColor(mStepViewTextColor);
        mTextPaint.setTextSize(mStepViewTextSize);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //在布局文件中，可能wrap_content，可能高宽不一致
        //获取模式 AT_MOST
        //宽度高度不一致时取最小值，保持是个正方形
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(width > height ? height : width, width > height ? height : width);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画外圆弧：
        RectF rectF = new RectF(mBorderWidth / 2, mBorderWidth / 2, getWidth() - mBorderWidth / 2,
                getWidth() - mBorderWidth / 2);
        canvas.drawArc(rectF, 135, 270, false, mOutPaint);
        //画内圆弧：百分比，由用户设置的
        if (mStepMax == 0) {
            return;//防止第一次进入时为0，引起错误
        }
        float sweepAngle = (float) mCurrentStep / mStepMax;
        canvas.drawArc(rectF, 135, sweepAngle * 270, false, mInnerPaint);

        //画文字
        String stepText = mCurrentStep + "";
        Rect textBounds = new Rect();
        mTextPaint.getTextBounds(stepText, 0, stepText.length(), textBounds);
        int dx = getWidth() / 2 - textBounds.width() / 2;//文字的起始位置
        //基线
        Paint.FontMetricsInt fontMetricsInt = mTextPaint.getFontMetricsInt();
        int dy = (fontMetricsInt.bottom = fontMetricsInt.top) - fontMetricsInt.bottom;
        int baseLine = getHeight() / 2 + dy;
        canvas.drawText(stepText, dx, baseLine, mTextPaint);
    }

    //其他，动画效果等
    public synchronized void setStepMax(int stepMax) {
        this.mStepMax = stepMax;
    }


    //    synchronized,防止多线程操作出错
    public synchronized void setCurrentStep(int currentStep) {
        this.mCurrentStep = currentStep;
        //不断绘制
        invalidate();
    }
}
