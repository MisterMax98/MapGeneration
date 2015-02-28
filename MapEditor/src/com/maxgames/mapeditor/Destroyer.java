package com.maxgames.mapeditor;

import java.util.LinkedList;

public class Destroyer {

	LinkedList<LinkedList<Block>> map;
	int x, y, move, size;

	int rand(int min, int max) {
		return (int) (Math.random() * (max - min + 1) + min);
	}

	public Destroyer(Map m) {
		this.map = m.map;
		this.size = m.size;
	}

	LinkedList<LinkedList<Block>> generateMap() {
		for (int i = 0; i < 100; i++) {
			x = size / 2 - 1;
			y = size / 2 - 1;
			for (int z = 0; z < size * 6; z++) {
				if (x >= size - 1 || x < 1 || y >= size - 1 || y < 1) {
					x = size / 2 - 1;
					y = size / 2 - 1;
				}
				map.get(x).set(y, new Block(x, y, 1));
				move = rand(0, 3);
				switch (move) {
				case 0: {
					x++;
					break;
				}
				case 1: {
					y++;
					break;
				}
				case 2: {
					x--;
					break;
				}
				case 3: {
					y--;
					break;
				}
				}
			}
		}
		cleanMap();
		cleanMap();
		cleanMap();
		return (map);
	}

	void cleanMap() {
		for (int mx = 1; mx < size - 2; mx++) {
			for (int my = 1; my < size - 2; my++) {
				if (map.get(mx).get(my).id == 0) {
					int clean = 0;
					if (map.get(mx + 1).get(my + 1).id == 0) {
						clean++;
					}
					if (map.get(mx + 1).get(my).id == 0) {
						clean++;
					}
					if (map.get(mx).get(my + 1).id == 0) {
						clean++;
					}
					if (map.get(mx - 1).get(my - 1).id == 0) {
						clean++;
					}
					if (map.get(mx - 1).get(my).id == 0) {
						clean++;
					}
					if (map.get(mx).get(my - 1).id == 0) {
						clean++;
					}
					if (map.get(mx - 1).get(my + 1).id == 0) {
						clean++;
					}
					if (map.get(mx + 1).get(my - 1).id == 0) {
						clean++;
					}
					if (clean <= 3) {
						map.get(mx).set(my, new Block(mx, my, 1));
					}
				}
			}
		}
	}
}
