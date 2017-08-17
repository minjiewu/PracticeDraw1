package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class Practice10HistogramView extends View {

    private Paint paint = new Paint();
    private static final int OFFSET = 18;
    private static final int RECT_WIDTH = 86;
    private Random random = new Random();

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        int x = (int) (getWidth() * 0.16f);
        int y = (int) (getHeight() * 0.75f);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(1);
        paint.setTextSize(42);
        paint.setAntiAlias(true);
        canvas.drawText("直方图", getWidth() / 2 - 50, getHeight() / 2 + 320, paint);

        paint.setStyle(Paint.Style.STROKE);
        float[] points = {x, (int) (getHeight() * 0.15f), x, y, x, y, (getWidth() * 0.85f), y};
        canvas.drawLines(points, paint);

        paint.setColor(Color.GREEN);
        paint.setTextSize(30);
        paint.setStyle(Paint.Style.FILL);
        String[] names = {"Froyo", "GB", "ICS", "JB", "KiKat", "L", "M"};
        for (int i = 0; i < 7; i++) {
            int height = random.nextInt(380);
            int locationX0 = x + OFFSET * (i + 1) + RECT_WIDTH * i;
            int locationX1 = x + OFFSET * (i + 1) + RECT_WIDTH * (i + 1);
            canvas.drawRect(locationX0, y - height, locationX1, y, paint);
            canvas.drawText(names[i], locationX0, y + 30, paint);
        }

    }
}
