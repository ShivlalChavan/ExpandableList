package com.e.expandablelist.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DBNAME = "MobileDB";

    private static final String MobileTable ="MobileTable";

    private static final String MobileId = "mobileId";

    private static final String  mTitle = "mTitle";

    private static final String RATING = "smilyRating";

    private static final String mDate = "mDate";

    private static final String mQuantity = "mQuantity";

    private static final String mPhoneType = "mPhoneType";

    private static final String mImage  = "mImage";





    public static final String mobileTable = "create table "+MobileTable+"(id INTEGER PRIMARY KEY AUTOINCREMENT , mobileId TEXT NOT NULL , mTitle VARCHAR(255) NOT NULL , smilyRating REAL ,mDate NUMERIC ,mQuantity INTEGER ,mPhoneType TEXT , mImage TEXT)";



    public DBHelper(Context context) {

        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(mobileTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+MobileTable);

    }



    public void add_phone(String custId,String feedback, String rating, String updatedDate ,String quantity ,String type, String image ){

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues value =new ContentValues();
        value.put(MobileId,custId);
        value.put(mTitle,feedback);
        value.put(RATING,Float.parseFloat(rating));
        value.put(mDate, updatedDate);
        value.put(mQuantity,Integer.parseInt(quantity));
        value.put(mPhoneType,type);
        value.put(mImage,image);
        db.insertWithOnConflict(MobileTable,null,value, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }


    public Cursor getPhonedetail(){

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor c = db.rawQuery( "SELECT * FROM "+MobileTable,null);
        return c;
    }


    public Cursor sortByQuantity(){

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c = db.rawQuery( "SELECT * FROM "+MobileTable+" ORDER BY "+mQuantity+" ASC ", null);
        return c;
    }

    public Cursor sortByRating(){

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c = db.rawQuery( "SELECT * FROM "+MobileTable+" ORDER BY "+RATING+" ASC ", null);
        return c;
    }

    public Cursor getFilterList(String startDate)
    {

        SQLiteDatabase db=this.getReadableDatabase();

        String resultQuery ="SELECT * FROM "+MobileTable+" WHERE "+mPhoneType+" =?";

        Cursor c = db.rawQuery( resultQuery,new String[] {startDate});
        return c;

    }


    public void deletelist(){

        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(MobileTable, null, null);
        db.close();
    }


}
