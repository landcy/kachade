package com.kachade.Dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import com.kachade.framework.exception.DBException;

public class HistoryDbController {
	private static final String SEARCH_HIS_TB = "search_histroy_table";
	private static final String KEY_WORDS = "KeyWords";
	private DBHelper dbHelperImpl;

	public HistoryDbController() {
		dbHelperImpl = new DBHelperImpl();
	}

	public static String creatTable() {
		String result = "CREATE TABLE IF NOT EXISTS " + SEARCH_HIS_TB + "( "
				+ "_id INTEGER PRIMARY KEY autoincrement, " // 主键 id 自动增长
				+ KEY_WORDS + " TEXT NOT NULL);";
		return result;
	}

	public static String dropTable() {
		String result = "DROP TABLE IF EXISTS " + SEARCH_HIS_TB;
		return result;
	}

	public boolean insertKeyWords(String keyWords) {
		if (keyWords == null)
			return false;
		if (isKeyWords(keyWords))
			return false;
		ContentValues cv = new ContentValues();
		cv.put(KEY_WORDS, keyWords);
		dbHelperImpl.insert(SEARCH_HIS_TB, cv);
		return true;
	}

	public List<String> getKeyWords() {
		List<String> result = new ArrayList<String>();
		String words = "";
		Cursor cursor = dbHelperImpl.query("SELECT " + KEY_WORDS + " FROM "
				+ SEARCH_HIS_TB, new String[] {});
		cursor.moveToFirst();
		while (cursor.moveToNext()) {
			words = cursor.getString(cursor.getColumnIndex(KEY_WORDS));
			result.add(words);
		}
		cursor.close();
		return result;
	}

	private boolean isKeyWords(String keyWords) {
		boolean flag = false;
		Cursor cursor = dbHelperImpl.query("SELECT " + KEY_WORDS + " FROM "
				+ SEARCH_HIS_TB + " WHERE " + KEY_WORDS + " = ?",
				new String[] { keyWords });
		while (cursor.moveToNext()) {
			flag = true;
		}
		cursor.close();
		return flag;
	}

	public synchronized void deleteKeyWords() {
		String sql = "DELETE FROM " + SEARCH_HIS_TB;
		try {
			dbHelperImpl.execute(sql, new Object[] {});
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
