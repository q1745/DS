package com.example.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * @Name:yao
 * @CreateDate: 2021/9/21 19:24
 * @ProjectName: DS
 * @Package: com.example.custom
 * @ClassName: RotateTextView
 */
public class RotateTextView extends androidx.appcompat.widget.AppCompatTextView {
    private String text="折扣";

    public RotateTextView(Context context) {
        super(context);
    }

    public RotateTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int w=getMeasuredWidth();
        canvas.rotate(-0,w,w);
        // 绘制这个三角形
        Paint p1 = new Paint();
        p1.setColor(Color.RED);// 设置红色
        p1.setStyle(Paint.Style.FILL);
        Path path = new Path();
        path.moveTo((int)(w/3), (int)(w/3));// 此点为多边形的起点
        path.lineTo((int)(w*3), (int)(w/3));
        path.lineTo(w, w);
        path.close(); // 使这些点构成封闭的多边形
        canvas.drawPath(path, p1);

        Paint p = new Paint();
        p.setColor(Color.WHITE);// 设置白色
        p.setTextSize((int)(w*0.15));//设置字体大小
        canvas.drawText(text, (int)(w*0.66), (int)(w*0.60), p);
        super.onDraw(canvas);
    }
    public void setText(String text) {
        this.text=text;
        invalidate();//重绘刷新Textview内容
    }
}
