package com.example.android.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SqliteDbHelper database;
    String inList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        database = new SqliteDbHelper(this);
    }

    public void Add(View view){
        EditText Hobbies = (EditText) findViewById(R.id.editText);
        inList = Hobbies.getText().toString();
        Hobbies.setText("");

        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(database.HOBBIE_INLIST ,inList);
        // Log.e("Content values are : ", contentValues.toString());
        long id = sqLiteDatabase.insert(database.TABLE_NAME, null, contentValues);

        if(id != -1)
        {
            Toast.makeText(this,"Data Added",Toast.LENGTH_SHORT).show();
        }
    }

    public void Show(View view){
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        String coloumn[]={database.COLUMN_HOBBIE_ID ,database.HOBBIE_INLIST};
        Cursor cursor = sqLiteDatabase.query(database.TABLE_NAME, coloumn, null, null, null, null, null);
        StringBuffer buff = new StringBuffer();
        while(cursor.moveToNext()){
            int index = cursor.getColumnIndex(database.HOBBIE_INLIST);
            inList = cursor.getString(index);
            buff.append(inList + "\n");
        }
        display(buff);
    }
    private void display(StringBuffer s) {
        TextView hobbielist = (TextView)findViewById(R.id.textView);
        hobbielist.setText(s);
    }
}
