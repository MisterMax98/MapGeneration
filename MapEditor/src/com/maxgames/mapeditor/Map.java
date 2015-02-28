package com.maxgames.mapeditor;

import java.util.LinkedList;

import android.content.Context;
import android.graphics.Canvas;

public class Map {
	LinkedList<LinkedList<Block>> map;

	DBManager dbm;
	int size;
	int blSize = 10;

	Map(int size, Context c) {
		this.size = size;
		dbm = DBManager.getInstance(c);
		// map = dbm.loadMap(size);
		// if (map == null) {
		map = new LinkedList<>();
		for (int x = 0; x < size; x++) {
			LinkedList<Block> mapx = new LinkedList<>();
			for (int y = 0; y < size; y++) {
				Block b = new Block(x, y, 0);
				mapx.add(b);
			}
			map.add(mapx);
		}
		// }
		map = (new Destroyer(this)).generateMap();
	}

	int rand(int min, int max) {
		return (int) (Math.random() * (max - min) + min);
	}

	public void drawM(Canvas canvas) {
		for (int x = 0; x < map.size(); x++) {
			for (int y = 0; y < map.get(x).size(); y++) {
				if (map.get(x).get(y) != null) {
					map.get(x).get(y).draw(canvas, blSize);
				}
			}
		}
	}

	public void saveMap() {
		// dbm.saveMap(map);
	}
}
