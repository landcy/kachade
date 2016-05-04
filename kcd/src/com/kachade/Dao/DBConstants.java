package com.kachade.Dao;

import java.util.ArrayList;
import java.util.List;
import com.kachade.framework.app.Version;

public class DBConstants {

	public static final String DATABASE_NAME = "kachade_cachedb.db";
	public static final int DATABASE_VERSION = Version.getVersionCode();

	public static List<String> DB_CREATE_SQL;

	static {
		DB_CREATE_SQL = new ArrayList<String>();

		DB_CREATE_SQL.add(HistoryDbController.dropTable());
		DB_CREATE_SQL.add(HistoryDbController.creatTable()); // 天气数据对象
		DB_CREATE_SQL.add(AccountDbController.dropTable());
		DB_CREATE_SQL.add(AccountDbController.creatTable()); // 天气数据对象

	}

}
