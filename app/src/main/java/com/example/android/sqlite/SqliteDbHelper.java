package com.example.android.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Aman on 19-05-2016.
 */
public class SqliteDbHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 5;
    private Context context;


    static final String DATABASE_NAME = "Sqlite.db";
    public static final String TABLE_NAME = "HobbieTable";
    public static final String COLUMN_HOBBIE_ID = "hobbie_id";
    public static final String HOBBIE_INLIST = "hobbie";

    private String SQL_CREATE_HOBBIE_TABLE = "CREATE TABLE " +  TABLE_NAME + " (" +
            COLUMN_HOBBIE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + HOBBIE_INLIST + " TEXT NOT NULL);";

    public SqliteDbHelper(Context context1) {

        super(context1, DATABASE_NAME, null, DATABASE_VERSION);
        context = context1;
        //Log.e("Aman", "constructor called");
        // Toast.makeText(context, "constructor called", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL(SQL_CREATE_HOBBIE_TABLE);
        //Toast.makeText(context, "oncreate called", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
        //Log.e("Aman", "onupgrade called");
    }


}
