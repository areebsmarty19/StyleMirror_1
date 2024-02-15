package com.example.stylemirror_1_1.Dbmodels;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    Cursor cursor;
    SQLiteDatabase db;
    public static final String USER_TABLE = "USERS";
    public static final String USER_ID = "USER_ID";
    public static final String USERNAME = "USERNAME";
    public static final String EMAIL = "EMAIL";
    public static final String PASSWORD = "PASSWORD";
    public static final String LOGGED_IN = "LOGGED_IN"; // New column for tracking login status

    public DatabaseHelper(Context context) {
        super(context, "Users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + USER_TABLE + " (" +
                USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USERNAME + " TEXT, " + EMAIL + " TEXT, " +
                PASSWORD + " VARCHAR, " + LOGGED_IN + " INTEGER DEFAULT 0)"; // Default value for login status
        sqLiteDatabase.execSQL(createTable);
        Log.d("Database", "Query running: " + createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        onCreate(sqLiteDatabase);
    }

    public boolean insertdata(String username , String email , String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(USERNAME, username);
        cv.put(EMAIL, email);
        cv.put(PASSWORD, password);
        long insert = db.insert(USER_TABLE, null, cv);
        Log.d("Database", "Successfully inserted");
        db.close();
        return insert != -1;
    }

    public Boolean checkEmail(String email){
        db = this.getWritableDatabase();
        cursor = db.rawQuery("SELECT * FROM " + USER_TABLE + " WHERE " + EMAIL + " = ?", new String[]{email});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

    public Boolean checkEmailPassword(String username, String password){
        db = this.getWritableDatabase();
        cursor = db.rawQuery("SELECT * FROM " + USER_TABLE + " WHERE " + USERNAME + " = ? AND " + PASSWORD + " = ?", new String[]{username, password});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

    public void setUserLoggedIn(boolean loggedIn) {
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(LOGGED_IN, loggedIn ? 1 : 0);
        db.update(USER_TABLE, cv, null, null);
    }

    public boolean isLoggedIn() {
        db = this.getWritableDatabase();
        cursor = db.rawQuery("SELECT * FROM " + USER_TABLE + " WHERE " + LOGGED_IN + " = 1", null);
        boolean loggedIn = cursor.getCount() > 0;
        cursor.close();
        return loggedIn;
    }
    // Add a method to retrieve the password associated with a given email
    public String getPasswordByEmail(String email) {
        db = this.getReadableDatabase();
        String password = null;
        cursor = db.rawQuery("SELECT " + PASSWORD + " FROM " + USER_TABLE + " WHERE " + EMAIL + " = ?", new String[]{email});
        if (cursor.moveToFirst()) {
            password = cursor.getString(cursor.getColumnIndex(PASSWORD));
        }
        cursor.close();
        return password;
    }

    public String getUsernameByIfLoggIn(){
        db = this.getReadableDatabase();
        String username = null;
        cursor = db.rawQuery("SELECT " + USERNAME + " FROM " + USER_TABLE + " WHERE " + LOGGED_IN + " = 1",null);
        if (cursor.moveToFirst()) {
            username = cursor.getString(cursor.getColumnIndex(USERNAME));
        }
        cursor.close();
        return username;
    }
}