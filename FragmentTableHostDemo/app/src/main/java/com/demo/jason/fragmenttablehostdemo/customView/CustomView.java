package com.demo.jason.fragmenttablehostdemo.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.demo.jason.fragmenttablehostdemo.R;

/**
 * Created by Jason on 2016/1/25.
 */
public class CustomView extends View {
    private String mCustomText;
    private int mCustomTextColor;
    private int mCustomTextSize;

    private Rect mBound;
    private Paint mPaint;
    public CustomView(Context context){
       this(context,null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public CustomView(Context context,AttributeSet attrs,int defStyle){
        super(context,attrs,defStyle);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView, defStyle, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++)
        {
            int attr = a.getIndex(i);
            switch (attr)
            {
                case R.styleable.CustomView_customText:
                    mCustomText = a.getString(attr);
                    break;
                case R.styleable.CustomView_customTextColor:
                    // 默认颜色设置为黑色
                    mCustomTextColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomView_customTextSize:
                    // 默认设置为16sp，TypeValue也可以把sp转化为px
                    mCustomTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;

            }

        }
        a.recycle();
        /**
         * 获得绘制文本的宽和高
         */
        mPaint = new Paint();
        mPaint.setTextSize(mCustomTextSize);
        // mPaint.setColor(mTitleTextColor);
        mBound = new Rect();
        mPaint.getTextBounds(mCustomText, 0, mCustomText.length(), mBound);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);

        mPaint.setColor(mCustomTextColor);
        canvas.drawText(mCustomText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);
    }
}
