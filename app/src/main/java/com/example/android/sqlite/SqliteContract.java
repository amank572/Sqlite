package com.example.android.sqlite;

import android.provider.BaseColumns;
import android.text.format.Time;

/**
 * Created by Aman on 19-05-2016.
 */
public class SqliteContract {


    /* Inner class that defines the table contents of the weather table */
    public static final class SqliteEntry implements BaseColumns {

        public static final String TABLE_NAME = "HobbieTable";

        public static final String COLUMN_HOBBIE_ID = "hobbie_id";

        public static final String HOBBIE_INLIST = "hobbie";
    }
}
