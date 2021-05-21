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
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'User1', 'user1@gmail.com','0328','7895641238', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'User2', 'user2@gmail.com','0328','8995641238', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'User3', 'user3@gmail.com','0328','7595645896', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'User4', 'user4@gmail.com','0328','9995640038', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'User5', 'user5@gmail.com','0328','9095648962', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'User6', 'user6@gmail.com','0328','8855640238', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'User7', 'user7@gmail.com','0328','8895640215', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'User8', 'user8@gmail.com','0328','9985021539', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'User9', 'user9@gmail.com','0328','9309565238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'User10', 'user10@gmail.com','0328','8292591201', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'User11', 'user11@gmail.com','0328','9015641200', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'User12', 'user12@gmail.com','0328','9995641999', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'User13', 'user13@gmail.com','0328','9119541001', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'User14', 'user14@gmail.com','0328','6254642205', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'User15', 'user15@gmail.com','0328','6893641266', 1010)");
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
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}