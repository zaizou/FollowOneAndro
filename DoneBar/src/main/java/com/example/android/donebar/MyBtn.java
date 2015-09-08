package com.example.android.donebar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by Assou on 29/08/2015.
 */
public class MyBtn extends Button {

    private TypedArray mesColors;
    private int CurrentPosition;
    private Rect myRect;
    private Paint mPaint;

    public MyBtn(Context context) {
        super(context);
        this.init();
    }



    public MyBtn(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public MyBtn(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init() {
        Resources resources=getResources();
        this.mesColors=resources.obtainTypedArray(R.array.mycolors);
        this.setText("Changement de coleur ");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if(changed)
            this.myRect=new Rect(Math.round(0.5f * getWidth() - 50),
                    Math.round(0.75f * getHeight() - 50),
                    Math.round(0.5f * getWidth() + 50),
                    Math.round(0.75f * getHeight() + 50));

        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            this.CurrentPosition++;
            this.CurrentPosition%=this.mesColors.length();
            this.mPaint.setColor(mesColors.getColor(this.CurrentPosition,-1));
            this.invalidate();
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(this.myRect,this.mPaint);
        super.onDraw(canvas);
    }
}
