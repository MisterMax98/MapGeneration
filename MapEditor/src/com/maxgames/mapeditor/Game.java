package com.maxgames.mapeditor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

@SuppressLint("NewApi")
public class Game extends View {
	Context c;
	Player pl;
	Map map;
	boolean first = true;
	int wH, wW;

	public Game(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public Game(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public Game(Context context, Map m) {
		super(context);
		this.map = m;
		this.c = context;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		if (first) {
			try {
				load();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			wW = this.getWidth();
			wH = this.getHeight();
			map.blSize = wW / 9;
			if (pl == null)
				pl = new Player(map.size / 2, map.size / 2, map.blSize);
			first = false;
			invalidate();
		} else {
			super.onDraw(canvas);
			map.drawM(canvas, pl.x - 4, pl.x + 4, pl.y - 4, pl.y + 4);
			pl.draw(canvas);
		}
	}

	public boolean onTouch(View v, MotionEvent event, int id) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_UP:
			float x = event.getX();
			float y = event.getY();
			if (y < wH / 4) {
				plMove(pl.x, pl.y - 1);
			} else {
				if (y > (wH / 4 * 3)) {
					plMove(pl.x, pl.y + 1);
				} else {
					if (x < wW / 2) {
						plMove(pl.x - 1, pl.y);
					} else {
						plMove(pl.x + 1, pl.y);
					}
				}
			}
		}
		try {
			save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		invalidate();
		return true;
	}

	void plMove(int x, int y) {
		if (x >= 0 && y >= 0 && x < map.size && y < map.size
				&& map.map.get(x).get(y).move) {
			pl.x = x;
			pl.y = y;
		}
	}

	void save() throws IOException {
		FileOutputStream fos = this.c.openFileOutput("data",
				Context.MODE_PRIVATE);
		ObjectOutputStream serial = new ObjectOutputStream(fos);
		serial.writeObject(pl);
		serial.close();
	}

	void load() throws IOException, ClassNotFoundException {
		FileInputStream fis = this.c.openFileInput("data");
		ObjectInputStream serial = new ObjectInputStream(fis);
		pl = (Player) serial.readObject();
		serial.close();
	}
}

class Player implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5277277038810029329L;
	int x, y;
	// Paint p;
	int size;

	Player(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}

	void draw(Canvas c) {
		Paint p = new Paint();
		p.setColor(Color.RED);
		c.drawRect((x - (x - 4)) * size, (y - (y - 4)) * size,
				(x + 1 - (x - 4)) * size, (y + 1 - (y - 4)) * size, p);
	}
}
