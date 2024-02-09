package com.example.stylemirror_1_1.Dbmodels;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    Cursor cursor;
    SQLiteDatabase db;
    public static final String USER_TABLE = "USERS";
    public static final String USER_ID = "USER_ID";
    public static final String USERNAME = "USERNAME ";
    public static final String EMAIL = "EMAIL";
    public static final String PASSWORD = "PASSWORD";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "Users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + USER_TABLE + " (" +
                                 USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                 USERNAME + "TEXT, " + EMAIL + " TEXT, " +
                                 PASSWORD + " VARCHAR)";
      //  sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL(createTable);
        Log.d("Database", "Query running: "+createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
   // public String fetchUsernameFromDb(){}
    public boolean registerUser(UserModel userModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(USERNAME,userModel.getUsername());
        cv.put(EMAIL,userModel.getEmail());
        cv.put(PASSWORD,userModel.getPassword());

        long insert = db.insert(USER_TABLE,null,cv);
        Log.d("Database", "Successfully inserted");
        db.close();
        if(insert == -1){
            return false;
        } else {
            return true;
        }
    }

     public boolean validatelogin(String username,String password){
        db = this.getReadableDatabase();
        String fetch = "SELECT * from "+USER_TABLE+" where "+USERNAME+"= '"+username+ "'"+"AND "+PASSWORD+" = '"+password+"'";
        cursor = db.rawQuery(fetch,null);

        if(cursor.moveToFirst()){
            close();
            return true;
        }
        else {
            close();
            return false;
        }
     }
     public void close(){
         db.close();
         cursor.close();
     }
}
