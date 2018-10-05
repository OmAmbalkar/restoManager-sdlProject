package com.example.chira.restomanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager extends SQLiteOpenHelper {

    public static String databaseName = "restoManager.db";
    public static String tableName = "menu";
    public static String billTableName = "alltransactions";
    public static String col1 = "id" ;
    public static String col2 = "item" ;
    public static String col3 = "rate" ;

    public DatabaseManager(Context context) {
        super(context, databaseName, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + tableName + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "item VARCHAR(50) NOT NULL, rate INT NOT NULL )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(sqLiteDatabase);
    }


    public void insertData(String item, int rate) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2,item);
        contentValues.put(col3,rate);
        database.insert(tableName,null,contentValues);
    }
    public Cursor getData(String item){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor res = database.rawQuery("select " + col3 +" from " + tableName +"where item =" + item,null);
        return res;
    }
    public Cursor getItems(){
        SQLiteDatabase database = this.getReadableDatabase();
        //String col[] = {col1,col2,col3};
        Cursor cursor = database.rawQuery("select " + col2 + " from " + tableName,null);
        return cursor;
    }
}
