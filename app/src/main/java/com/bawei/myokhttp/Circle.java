package com.bawei.myokhttp;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2017/9/22.
 * 1506A
 * 郝健澄
 */

public class Circle  extends Drawable{
    Paint paint=new Paint();
    private Bitmap bitmap;
    int radius;

    public Circle(Bitmap bitmap) {
        this.bitmap = bitmap;
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP));
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int min = Math.min(width, height);
        radius=min/2;
    }


    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawCircle(radius,radius,radius,paint);

    }

    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {
        paint.setAlpha(alpha);

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);

    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }



    @Override
    public int getIntrinsicWidth() {
        return radius*2;
    }

    @Override
    public int getIntrinsicHeight() {
        return radius*2;
    }
}
