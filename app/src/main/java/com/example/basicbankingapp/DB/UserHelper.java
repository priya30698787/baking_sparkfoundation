package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL, "
                + UserEntry.COLUMN_USER_EMAIL + "  VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR );";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(3838561000,' Abhishek',9472.00,'arya888@gmail.com','XXXXXXXXXXXX8765','BAC09876543')");
        db.execSQL("insert into " + TABLE_NAME + " values(8888777777,'Anshika',4398.46,'anshika777@gmail.com','XXXXXXXXXXXX5678','CAB21098765')");
        db.execSQL("insert into " + TABLE_NAME + " values(8000899999,'JK',113.90,'jeonjk7777@gmail.com','XXXXXXXXXXXX1134','jkv109876666')");
        db.execSQL("insert into " + TABLE_NAME + " values(8888882222,'Kamini',582.67,'kamini666@gmail.com','XXXXXXXXXXXX0001','BCA98765432')");
        db.execSQL("insert into " + TABLE_NAME + " values(335261718,'Mahima',1359.56,'mahima555@gmail.com','XXXXXXXXXXXX0001','CAB87654321') ");
        db.execSQL("insert into " + TABLE_NAME + " values(3467845678,'Nishant',1500.01,'Nishant444@gmail.com','XXXXXXXXXXXX1000','ABC76543210') ");
        db.execSQL("insert into " + TABLE_NAME + " values(1234567890,'Priya',2603.48,'priya333@gmail.com','XXXXXXXXXXXX2222','BCA65432109')");
        db.execSQL("insert into " + TABLE_NAME + " values(12376543232,'Richa',4398.46,'richa222@gmail.com','XXXXXXXXXXXX3333','CAB21098765') ");
        db.execSQL("insert into " + TABLE_NAME + " values(1234456789,'Sakshi',945.16,'sakshi111@gmail.com','XXXXXXXXXXXX3332','CAB54321098') ");
        db.execSQL("insert into " + TABLE_NAME + " values(8978787867,'Saloni',5936.00,'saloni000@gmail.com','XXXXXXXXXXXX4444','ABC43210987') ");
        db.execSQL("insert into " + TABLE_NAME + " values(6767676757,'Surya',857.22,'surya999@gmail.com','XXXXXXXXXXXX5551','BCA32109876') ");
        db.execSQL("insert into " + TABLE_NAME + " values(6767676767,'S S noor',4398.46,'noor8888@gmail.com','XXXXXXXXXXXX1555','CAB21098765') ");
        db.execSQL("insert into " + TABLE_NAME + " values(8989898989,'Tanya',273.90,'tanyatanu7777@gmail.com','XXXXXXXXXXXX1234','ABC10987654')");
        db.execSQL("insert into " + TABLE_NAME + " values(8019899999,'V',2113.90,'taetae7777@gmail.com','XXXXXXXXXXXX1134','jkv10987654')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}