package com.maxgames.mapeditor;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Block {
	int x, y;
	int col;
	Paint p;
	int id;

	Block(int x, int y, int id) {
		this.x = x;
		this.y = y;
		this.id = id;
		switch (id) {
		case 1: {
			this.col = Color.GREEN;
			break;
		}
		case 2: {
			this.col = Color.GRAY;
			break;
		}
		default: {
			this.col = Color.BLACK;
			break;
		}
		}
		p = new Paint();
		p.setColor(this.col);
	}

	void draw(Canvas c, int size) {
		c.drawRect(x * size, y * size, (x + 1) * size, (y + 1) * size, p);
	}
}
