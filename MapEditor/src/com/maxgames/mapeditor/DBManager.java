package com.maxgames.mapeditor;

import java.io.File;
import java.util.LinkedList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
	/*
	 * TABLES: ------- MAP ID INTEGER
	 */
	private Context context;
	private String DB_NAME = "map1.db";

	private SQLiteDatabase db;

	private static DBManager dbManager;

	public static DBManager getInstance(Context context) {
		if (dbManager == null) {
			dbManager = new DBManager(context);
		}
		return dbManager;
	}

	private DBManager(Context context) {
		this.context = context;
		db = context.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
		createTablesIfNeedBe();
	}

//	void saveMap(LinkedList<LinkedList<Block>> map) {
//		db.delete("MAP", null, null);
//		for (int x = 0; x < map.size(); x++) {
//			for (int y = 0; y < map.get(x).size(); y++) {
//				if (map.get(x).get(y) != null) {
//					Block bl = map.get(x).get(y);
//					db.execSQL("INSERT INTO MAP VALUES (" + bl.id + ");");
//				} else {
//					db.execSQL("INSERT INTO MAP VALUES (" + 2 + ");");
//				}
//			}
//		}
//	}
//
//	LinkedList<LinkedList<Block>> loadMap(int size) {
//		if (dbExist()) {
//			Cursor cursor = db.rawQuery("SELECT * FROM MAP;", null);
//			boolean hasMoreData = cursor.moveToFirst();
//
//			LinkedList<LinkedList<Block>> map = new LinkedList<>();
//			for (int x = 0; x < size; x++) {
//				LinkedList<Block> mapx = new LinkedList<>();
//				for (int y = 0; y < size; y++) {
//					if (hasMoreData) {
//						int id = Integer.parseInt(cursor.getString(0));
//						Block b = new Block(x, y, id);
//						mapx.add(b);
//						hasMoreData = cursor.moveToNext();
//					} else {
//						Block b = new Block(x, y, 2);
//						mapx.add(b);
//					}
//				}
//				map.add(mapx);
//			}
//			return map;
//		} else
//			return null;
//	}

	private void createTablesIfNeedBe() {
		db.execSQL("CREATE TABLE IF NOT EXISTS MAP (ID INTEGER);");
	}

	private boolean dbExist() {
		File dbFile = context.getDatabasePath(DB_NAME);
		return dbFile.exists();
	}

}
