package com.example.android_sqllite_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class HotOrNot {

	private static final String TAG = null;
	public static final String KEY_ID = "_id";
	public static final String KEY_NAME = "persons_name";
	public static final String KEY_HOTNESS = "persons_hotness";

	private static final String DATABASE_NAME = "HotOrNotDBFinal";
	private static final String DATABASE_TABLE = "list";
	private static final int DATABASE_VERSION = 1;

	private DBHelper ourHelper;
	private SQLiteDatabase ourDatabase;
	private final Context ourContext;

	private class DBHelper extends SQLiteOpenHelper {

		public DBHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub

			
			
			db.execSQL("CREATE TABLE list(_id integer primary key autoincrement , persons_name text not null , persons_hotness text not null)" 
			
					);	
			
			Log.e(TAG, "Table has been created");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub

			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}

	}

	public HotOrNot(Context c) {

		ourContext = c;

	}

	public HotOrNot open() throws SQLException {
		// TODO Auto-generated method stub
		ourHelper = new DBHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;

	}

	public long createEntry(String getName, String getHotness) {
		// TODO Auto-generated method stub

		ContentValues cv = new ContentValues();
		cv.put(KEY_NAME, getName);
		cv.put(KEY_HOTNESS, getHotness);
		
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
		
		
	}

	public void close() {
		// TODO Auto-generated method stub
		ourHelper.close();
		
	}

	public String getData() {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ID, KEY_NAME, KEY_HOTNESS};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		String result = "";
		
		int iRow = c.getColumnIndex(KEY_ID);
		int iName = c.getColumnIndex(KEY_NAME);
		int iHotness = c.getColumnIndex(KEY_HOTNESS);
		
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			result = result + c.getString(iRow) + " " + c.getString(iName) + " " + c.getString(iHotness) + "\n";
		}
		
		return result;
	}

	public String getName(Long l) {
		// TODO Auto-generated method stub
		String[] columns = new String []{KEY_ID,KEY_NAME,KEY_HOTNESS};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ID + " = " + l, null, null, null, null);
		if(c!=null){
			c.moveToFirst();
			String name = c.getString(1);
			return name;
			
		}
		return null;
	}

	public String getHotness(Long l ) {
		// TODO Auto-generated method stub
		String[] columns = new String []{KEY_ID,KEY_NAME,KEY_HOTNESS};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ID + " = " + l, null, null, null, null);
		if(c!=null){
			c.moveToFirst();
			String hotness = c.getString(2);
			return hotness;
			
		}

		return null;
	}

	public void updateEntry(Long mLong, String mName, String mhotness) {
		// TODO Auto-generated method stub
		ContentValues cvUpdate = new ContentValues();
		cvUpdate.put(KEY_NAME, mName);
		cvUpdate.put(KEY_HOTNESS, mhotness);
		
		ourDatabase.update(DATABASE_TABLE, cvUpdate, KEY_ID + " = " + mLong , null);
	}

	public void deleteEntry(Long dlong) {
		// TODO Auto-generated method stub
		ourDatabase.delete(DATABASE_TABLE, KEY_ID + "=" + dlong, null);
		
	}

}
