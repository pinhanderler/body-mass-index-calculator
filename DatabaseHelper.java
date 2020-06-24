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
	private static final String COLUMN_USER_BIRTHDAY_DATE = null;

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
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
}
