package com.example.hiennv.apppda.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.hiennv.apppda.utils.AppConstants;

public class DatabaseHelper extends SQLiteOpenHelper {
    private SQLiteDatabase database;
    public DatabaseHelper(Context context) {
        super(context, AppConstants.DATABASE_NAME, null, AppConstants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
