package com.kachade.Dao;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.kachade.framework.app.Version;
import com.kachade.framework.util.Loger;

public class DBHelperImpl extends DBHelper {

	public DBHelperImpl() {
		super(DBConstants.DATABASE_NAME, DBConstants.DATABASE_VERSION,
				DBConstants.DB_CREATE_SQL);
	}

	/**
	 * 该处要区别升级的不同原始版本,做不同的数据库更新处理
	 */
	@Override
	protected void UpgradeDB(SQLiteDatabase db, int oldVersion, int newVersion) {
		Loger.d("================oldVersion" + oldVersion + ",newVersion"
				+ newVersion);
		if (db != null) {
			try {
				db.beginTransaction();
				if (oldVersion < Version.getVersionCode()) {

				}

				db.setTransactionSuccessful();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				db.endTransaction();
			}
		} else {
			throw new IllegalArgumentException(getClass().getSimpleName()
					+ "\tonUpgrade()");
		}

	}

	@Override
	protected void InitDB(SQLiteDatabase db) {

	}

}
