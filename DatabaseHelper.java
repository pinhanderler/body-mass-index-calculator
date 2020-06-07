package com.sport_of_life.sportoflife.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sport_of_life.sportoflife.model.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "UserManager.db";
    private static final String TABLE_USER = "user";

    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_KULLANICI_ADI = "user_kullanici_adi";
    private static final String COLUMN_USER_AD = "ad";
    private static final String COLUMN_USER_SOYAD = "soyad";
    private static final String COLUMN_USER_EMAIL = "email";
    private static final String COLUMN_USER_DOGUM_TARIHI = "dogum_tarihi";
    private static final String COLUMN_USER_SIFRE = "sifre";

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_KULLANICI_ADI + " TEXT,"
            + COLUMN_USER_AD + " TEXT," + COLUMN_USER_SOYAD + " TEXT," + COLUMN_USER_EMAIL + " TEXT,"
            + COLUMN_USER_DOGUM_TARIHI + " TEXT," + COLUMN_USER_SIFRE + " TEXT" + ")";

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
        values.put(COLUMN_USER_KULLANICI_ADI, user.getKullaniciAdi());
        values.put(COLUMN_USER_AD, user.getAd());
        values.put(COLUMN_USER_SOYAD, user.getSoyad());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_DOGUM_TARIHI, user.getDogumTarihi());
        values.put(COLUMN_USER_SIFRE, user.getSifre());

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public List<User> getAllUser(){

        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_KULLANICI_ADI,
                COLUMN_USER_AD,
                COLUMN_USER_SOYAD,
                COLUMN_USER_EMAIL,
                COLUMN_USER_DOGUM_TARIHI,
                COLUMN_USER_SIFRE,
        };

        String sortOrder =
                COLUMN_USER_KULLANICI_ADI + " ASC";
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
                user.setKullaniciAdi((cursor.getString(cursor.getColumnIndex(COLUMN_USER_KULLANICI_ADI))));
                user.setAd((cursor.getString(cursor.getColumnIndex(COLUMN_USER_AD))));
                user.setSoyad((cursor.getString(cursor.getColumnIndex(COLUMN_USER_SOYAD))));
                user.setEmail((cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL))));
                user.setDogumTarihi((cursor.getString(cursor.getColumnIndex(COLUMN_USER_DOGUM_TARIHI))));
                user.setSifre((cursor.getString(cursor.getColumnIndex(COLUMN_USER_SIFRE))));

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
        values.put(COLUMN_USER_KULLANICI_ADI, user.getKullaniciAdi());
        values.put(COLUMN_USER_AD, user.getAd());
        values.put(COLUMN_USER_SOYAD, user.getSoyad());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_DOGUM_TARIHI, user.getDogumTarihi());
        values.put(COLUMN_USER_SIFRE, user.getSifre());

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

        String selection = COLUMN_USER_KULLANICI_ADI + " = ?";

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

    public boolean checkUser(String kullaniciadi, String password){

        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = COLUMN_USER_KULLANICI_ADI + " = ?" + " AND " + COLUMN_USER_SIFRE + " = ?";

        String[] selectionArgs = {kullaniciadi, password};

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
