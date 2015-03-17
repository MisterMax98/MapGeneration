package com.maxgames.mapeditor;

import java.io.Serializable;
import java.util.LinkedList;

import android.content.Context;
import android.graphics.Canvas;

public class Map implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5522171676438645319L;

	LinkedList<LinkedList<Block>> map;

	DBManager dbm;
	int size;
	int blSize = 10;
	Context c;

	Map(int size, Context c) {
		this.size = size;
		dbm = DBManager.getInstance(c);
		// map = dbm.loadMap(size);
		// if (map == null) {
		map = new LinkedList<>();
		for (int x = 0; x < size; x++) {
			LinkedList<Block> mapx = new LinkedList<>();
			for (int y = 0; y < size; y++) {
				Block b = new Block(0,c);
				mapx.add(b);
			}
			map.add(mapx);
		}
		// }
		map = (new Destroyer(this)).generateMap();
		this.c = c;
	}

	int rand(int min, int max) {
		return (int) (Math.random() * (max - min) + min);
	}

	public void drawM(Canvas canvas, int sx, int fx, int sy, int fy) {
		for (int x = sx; x <= fx; x++) {
			for (int y = sy; y <= fy; y++) {
				if (x >= 0 && y >= 0 && x < size && y < size
						&& map.get(x).get(y) != null) {
					map.get(x).get(y).draw(canvas, blSize, x - sx, y - sy);
				}
			}
		}
	}

	public void saveMap() {
		// dbm.saveMap(map);
	}
}
