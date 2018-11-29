package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PetDbHelper extends SQLiteOpenHelper {

    // Name of the database file
    private static final String DATABASE_NAME = "shelter.db";

     // Database version. If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;

    // Create a String that contains the SQL statement to create the pets table
    private String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + PetContract.PetEntry.TABLE_NAME + " ("
            + PetContract.PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PetContract.PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, "
            + PetContract.PetEntry.COLUMN_PET_BREED + " TEXT, "
            + PetContract.PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, "
            + PetContract.PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";

    private String SQL_DROP_PETS_TABLE = "DROP TABLE IF EXISTS " + DATABASE_NAME;
    /**
     * Constructs a new instance of {@link PetDbHelper}.
     * @param context of the app
     */
    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_DROP_PETS_TABLE);
        onCreate(db);

    }
}
