package com.kachade.Dao;

import com.kachade.framework.exception.DBException;

public class AccountDbController {
	private static final String ACCOUNT_TB = "account_info_table";
	private static final String NAME = "Name";
	private static final String PASSWORD = "Password";
	private static final String PHONENUM = "PhoneNumber";
	private static final String USER_ID = "UserID";
	private static final String NICK_Name = "NickName";
	private static final String SEX = "Sex";
	private static final String BIRTHDAY = "Birthday";
	private static final String IMAGE = "Image";
	private static final String ISMERCHANT = "IsMerchant";
	private static final String KACHABI = "Kachabi";
	private static final String TOTAL_KACHABI = "TotalKachabi";
	private static final String CHARACTER_SIGNATURE = "CharacterSignature";

	private DBHelper dbHelperImpl;

	public AccountDbController() {
		dbHelperImpl = new DBHelperImpl();
	}

	public static String creatTable() {
		String result = "CREATE TABLE IF NOT EXISTS "
				+ ACCOUNT_TB
				+ "( "
				+ "_id INTEGER PRIMARY KEY autoincrement, " // 主键 id 自动增长
				+ NAME + " TEXT," + PASSWORD + " TEXT NOT NULL," + PHONENUM
				+ " TEXT NOT NULL," + USER_ID + " TEXT NOT NULL," + NICK_Name
				+ " TEXT NOT NULL," + SEX + " TEXT NOT NULL," + BIRTHDAY
				+ " TEXT NOT NULL," + IMAGE + " TEXT NOT NULL," + ISMERCHANT
				+ " INTEGER," + KACHABI + " INTEGER," + TOTAL_KACHABI
				+ " INTEGER," + CHARACTER_SIGNATURE + " TEXT);";
		return result;
	}

	public static String dropTable() {
		String result = "DROP TABLE IF EXISTS " + ACCOUNT_TB;
		return result;
	}

	public synchronized void insertAccount(String id, String name, int isFav) {
		String sql = "INSERT INTO " + ACCOUNT_TB + " VALUES(NULL, ?, ?, ?)";
		try {
			dbHelperImpl.execute(sql, new Object[] { id, name, isFav });
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
