package com.avinash.findmydrug;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by AVINASH on 17-03-2018.
 */

public class MySQLiteNotificationData {
    public static final String DATABASE_NAME = "findMyDrug";
    public static final String DATABASE_TABLE = "notifications";
    public static final int DATABASE_VERSION = 1;
    public static final String TAG = "MySQLiteNotificationData";

    public static final String COL_ROW_ID = "_id";
    public static final String COL_MESSAGE = "message";

    private static final String DATABASE_CREATE = "CREATE table "+DATABASE_TABLE+"("+COL_ROW_ID+" integer primary key autoincrement,"+
            COL_MESSAGE+" text not null);";

    Context context;
    DatabaseHelper DBHelper;
    SQLiteDatabase db;
    public MySQLiteNotificationData(Context ctx){
        this.context=ctx;
        DBHelper = new DatabaseHelper(context);
    }

    public static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }

        @SuppressLint("LongLogTag")
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG,"Upgrading database from version "+oldVersion+" to "+newVersion+", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }

    MySQLiteNotificationData open() throws SQLException{
        db = DBHelper.getWritableDatabase();
        return this;
    }

    void close(){
        DBHelper.close();
    }

    long insertNotification(String message){
        ContentValues initialValues = new ContentValues();
        initialValues.put(COL_MESSAGE,message);
        return db.insert(DATABASE_TABLE,null, initialValues);
    }

    Cursor viewNotifications(){
        return db.query(DATABASE_TABLE,
                new String[]{
                    COL_ROW_ID,
                    COL_MESSAGE
                },
                null,
                null,
                null,
                null,
                null
                );
    }
}
