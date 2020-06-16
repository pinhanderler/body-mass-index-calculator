package com.calculator.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.calculator.model.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "UserManager.db";
    private static final String TABLE_USER = "user";

    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_USER_NAME = "user_name";
    private static final String COLUMN_USER_NAME = "name";
    private static final String COLUMN_USER_SURNAME = "surname";
    private static final String COLUMN_USER_EMAIL = "email";
    private static final String COLUMN_USER_BIRTHDAY_DAY = "birthday_date";
    private static final String COLUMN_USER_PASSWORD = "password";

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER NAME + " TEXT,"
            + COLUMN_USER_NAME + " TEXT," + COLUMN_USER_SURNAME + " TEXT," + COLUMN_USER_EMAIL + " TEXT,"
            + COLUMN_USER_BIRTHDAY_DATE + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    public DatabaseHelper(Context context){
      super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){ db.execSQL(CREATE_USER_TABLE);}

    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(DROP_USER_TABLE);
        onCreate(db);
    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getUserName());
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_Surname, user.getSurname());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_BIRTHDAY_DATE, user.getBirthdayDate());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public List<User> getAllUser(){

        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_USER_NAME,
                COLUMN_USER_NAME,
                COLUMN_USER_SURNAME,
                COLUMN_USER_EMAIL,
                COLUMN_USER_BIRTHDAY_DATE,
                COLUMN_USER_PASSWORD,
        };

 Dize sortOrder =  COLUMN_USER_NAME  +  " ASC " ;    
                 
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USER,
                columns,
                null,
                null,
                null,
                null,
                sortOrder);

        if(cursor.moveToFirst()){
            do{
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setUserId((cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setName((cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME))));
                user.setSurname((cursor.getString(cursor.getColumnIndex(COLUMN_USER_SURNAME))));
                user.setEmail((cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL))));
                user.setBirthdayDate((cursor.getString(cursor.getColumnIndex(COLUMN_USER_BIRTHDAY_DATE))));
                user.setPassword((cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD))));

                userList.add(user);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return userList;
    }

    public void updateUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_USER_NAME, user.getUserName());
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_SURNAME, user.getSurname());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_BIRTHDAY_DATE, user.getBirthdayDate());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        db.update(TABLE_USER, values,COLUMN_USER_ID + " = ?", new String[]{String.valueOf(user.getId())});

        db.close();
    }

    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_USER, COLUMN_USER_ID + " =?", new String[]{String.valueOf(user.getId())});
        db.close();
    }

    public boolean checkUser(String email) {

        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = COLUMN_USER_USER_NAME + " = ?";

        String[] selectionArgs = {email};

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }

        return false;
    }

    public boolean checkUser(String username, String password){

        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = COLUMN_USER_USER_NAME + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        String[] selectionArgs = {username,password;

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}
