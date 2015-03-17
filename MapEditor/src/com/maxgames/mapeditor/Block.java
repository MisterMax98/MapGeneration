package com.maxgames.mapeditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Block {
	int col;
	int id;
	boolean move;
	Bitmap bm;
	Paint p;

	Block(int id, Context c) {
		this.id = id;
		switch (id) {
		case 1: {
			this.col = Color.GREEN;
			bm = BitmapFactory.decodeResource(c.getResources(),
					R.drawable.map_1);
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
		p = new Paint();
		p.setColor(this.col);
	}

	void draw(Canvas c, int size, int x, int y) {

		c.drawBitmap(Bitmap.createScaledBitmap(bm, size, size, true), x * size,
				y * size, p);
		// c.drawRect(x * size, y * size, (x + 1) * size, (y + 1) * size, p);
	}
}
