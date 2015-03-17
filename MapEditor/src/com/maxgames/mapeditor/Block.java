package com.maxgames.mapeditor;

import java.io.Serializable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Block implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7013734098144142028L;
	int col;
	int id;
	boolean move;

	Block(int id) {
		this.id = id;
		switch (id) {
		case 1: {
			this.col = Color.GREEN;
			move = true;
			break;
		}
		case 2: {
			this.col = Color.GRAY;
			move = true;
			break;
		}
		default: {
			this.col = Color.BLACK;
			move = false;
			break;
		}
		}
	}

	void draw(Canvas c, int size, int x, int y) {
		Paint p;
		p = new Paint();
		p.setColor(this.col);
		//Bitmap bm = BitmapFactory.decodeResource(, );
		c.drawRect(x * size, y * size, (x + 1) * size, (y + 1) * size, p);
	}
}
