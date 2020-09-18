package com.example.mapproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

public class DatabaseHelper {
    public static final String DB_NAME = "LocationDB";

    public static final String TABLE_LOCATION = "LocationTable";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String TITLE = "title";
    public static final String V1 = "v1";
    public static final String V2 = "v2";

    public static final int DB_VERSION = 1;

    Context mContext;

    public DatabaseHelper(Context mContext) {
        this.mContext = mContext;
    }

    public SQLiteDatabase openDB(){
        return mContext.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
    }

    public void closeDB(SQLiteDatabase db){
        db.close();
    }

    private  static final String CreateTable = " CREATE TABLE IF NOT EXISTS " +TABLE_LOCATION+ "("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" TEXT, "+TITLE+" TEXT, "+V1+" DOUBLE, "+V2+" DOUBLE);";

    //NGHIEP VU

    public void createTable(){
        SQLiteDatabase db = openDB();
        db.execSQL(CreateTable);
        closeDB(db);
    }

    public void insertLocation(String name, String title, double v1, double v2){
        SQLiteDatabase db = openDB();
        ContentValues cv = new ContentValues();
        cv.put(NAME, name);
        cv.put(TITLE, title);
        cv.put(V1, v1);
        cv.put(V2,v2);
        db.insert(TABLE_LOCATION,null, cv);
        closeDB(db);
    }

    public ArrayList<Location> fetch_ListLocation(){
        SQLiteDatabase db = openDB();
        ArrayList<Location> listLocation = new ArrayList<>();
        String query = "Select * from "+TABLE_LOCATION;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor!=null) {
            if (cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    String title = cursor.getString(2);
                    double v1 = cursor.getDouble(3);
                    double v2 = cursor.getDouble(4);
                    listLocation.add(new Location(id, name, title, v1, v2));
                } while (cursor.moveToNext());
            }
        }
        closeDB(db);
        return listLocation;
    }

    public int UpdateLocation(int id, String name, String title, double v1, double v2){
        SQLiteDatabase db = openDB();
        ContentValues cv = new ContentValues();
        cv.put(NAME, name);
        cv.put(TITLE, title);
        cv.put(V1, v1);
        cv.put(V2,v2);
        int i = db.update(TABLE_LOCATION, cv, ID+ "=" + id, null);
        closeDB(db);
        return i;
    }

    public Location getLocation_by_id(int idd){
        SQLiteDatabase db = openDB();
        Location location = null;
        String query = "Select * from "+TABLE_LOCATION+ " where "+ID+" = "+idd;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor!=null){
            if(cursor.moveToFirst()){
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String title = cursor.getString(2);
                Double v1 = cursor.getDouble(3);
                Double v2 = cursor.getDouble(4);
                location = new Location(id,name,title,v1,v2);
            }
        }
        closeDB(db);
        return location;
    }

    public int deleteLocation_by_id(int idd){
        SQLiteDatabase db = openDB();
        int i = db.delete(TABLE_LOCATION, ID+"="+idd, null);
        closeDB(db);
        return i;
    }

    public int getLocation_by_v1v2(double v1, double v2){
        SQLiteDatabase db = openDB();
        int id = 0;
        String query = "Select * from " +TABLE_LOCATION+" where V1 = "+v1+" and V2 = " +v2;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor!=null){
            if(cursor.moveToFirst()){
                 id =  cursor.getInt(0);
            }
        }
        closeDB(db);
        return  id;
    }
}
