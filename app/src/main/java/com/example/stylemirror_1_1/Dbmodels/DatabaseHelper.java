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

    public DatabaseHelper(Context context) {
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
        db.execSQL("drop Table if exists USER_TABLE");
    }
   // public String fetchUsernameFromDb(){}
    public boolean insertdata(String username , String email , String password){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(USERNAME,username);
        cv.put(EMAIL,email);
        cv.put(PASSWORD,password);

        long insert = db.insert(USER_TABLE,null,cv);
        Log.d("Database", "Successfully inserted");
        db.close();
        if(insert == -1){
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkEmail(String email){
        db  = this.getWritableDatabase();
        cursor = db.rawQuery("Select * from users where email = ?", new String[]{email});

        if(cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }

//    public boolean validatelogin(String email,String password){
//        db = this.getReadableDatabase();
//        String fetch = "SELECT * from "+USER_TABLE+" where "+EMAIL+"= '"+email+PASSWORD+" = '"+password+"'";
//        cursor = db.rawQuery(fetch,null);
//
//        if(cursor.moveToFirst()){
//            close();
//            return true;
//        }
//        else {
//            close();
//            return false;
//        }
//     }
     public void close(){
         db.close();
         cursor.close();
     }
    public Boolean checkEmailPassword(String email, String password){
        db = this.getWritableDatabase();
        cursor = db.rawQuery("Select * from users where email = ? and password = ?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
}
