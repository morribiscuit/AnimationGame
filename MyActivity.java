package com.example.AnimationGame;

import android.app.Activity;
import android.content.Context;
import android.graphics.*;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.*;

import java.util.ArrayList;
import java.util.Random;


public class MyActivity extends Activity {
	int rx=30,ry=20;
	int gx = 100,gy = 100;
	int yx = 300, yy=50;
	int ra =10, ga =20, ya = 15;

	Bitmap myImage;
	DrawView drawView;
	ArrayList<Ball> ball = new ArrayList<Ball>();



	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Set full screen view
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		drawView = new DrawView(this);
		setContentView(drawView);
		drawView.requestFocus();
		myImage= BitmapFactory.decodeResource(getResources(), R.drawable.ball);
		Display display = getWindowManager().getDefaultDisplay();
		int width = display.getWidth();
		int height = display.getHeight();
		ball.add(new Ball(100, 100, 0, 0, width, height));
		ball.add(new Ball(200, 200, 0, 0, width, height));
		ball.add(new Ball(300, 180, 0, 0, width, height));
		drawView.setOnTouchListener((View.OnTouchListener)this);


	}
	public boolean onTouch(View arg0, MotionEvent arg1) {
		Display display = getWindowManager().getDefaultDisplay();
		int width = display.getWidth();
		int height = display.getHeight();
		Random rx = new Random();
		Random ry = new Random();

		int rangex = width + 1;
		int rangey = height + 1;

		int Randomx = rx.nextInt(rangex);
		int Randomy = ry.nextInt(rangey);

		if (arg1.getX() > (width / 2)) {
			ball.add(new Ball(Randomx, Randomy, 0, 0, width, height));
		}
		else
		{
			ball.clear();
		}
		return false;
	}


	public void doDraw(Canvas canvas, Paint paint) {
				for(int i=0;i<ball.size();i++){
					ball.get(i).update(0.5);
					canvas.drawCircle((int) ball.get(i).x, (int) ball.get(i).y, 27, paint);
				}


	}

}
