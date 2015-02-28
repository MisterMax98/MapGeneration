package com.maxgames.mapeditor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MapEdit extends View {
	Map map;
	String t1, t2;
	Context c;

	public MapEdit(Context context) {
		super(context);
		c = context;
		map = new Map(70, context);
		t1 = "";
		t2 = "";
	}

	public MapEdit(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MapEdit(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		map.drawM(canvas);
		Paint p = new Paint();
		p.setTextSize(30);
		canvas.drawText(t1, 0, 30, p);
		canvas.drawText(t2, 0, 60, p);
	}

	public boolean onTouch(View v, MotionEvent event, int id) {
		map = new Map(70, c);
		// int size = map.blSize;
		// t1 = "" + event.getX();
		// t2 = "" + event.getY();
		// switch (event.getActionIndex()) {
		// case MotionEvent.ACTION_DOWN:
		// case MotionEvent.ACTION_MOVE: {
		// double xt = event.getX();
		// double yt = event.getY();
		// int x = (int) (xt / size);
		// int y = (int) (yt / size);
		// if (x < map.map.size() && y < map.map.get(0).size() && x >= 0
		// && y >= 0) {
		// map.map.get(x).set(y, new Block(x, y, id));
		// t2 = "" + x + " " + y;
		// }
		// break;
		// }
		// }
		invalidate();
		return true;
	}
}
