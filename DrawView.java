package com.example.AnimationGame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawView extends View{
    MyActivity parent;
    Paint paint = new Paint();

    public DrawView(MyActivity s) {
        super(s);
        parent = s;
        setFocusable(true);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
    }
    
    @Override
    public void onDraw(Canvas canvas) {
    	parent.doDraw(canvas, paint);
		try {  
	         Thread.sleep(10);  
	      } catch (InterruptedException e) { }
	      invalidate();
    }
}
