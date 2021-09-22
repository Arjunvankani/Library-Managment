package com.example.library_managment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import org.w3c.dom.Text;
public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Book.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Bookdetails(Bid Text primary key,Bname Text,AuthorName Text,publicationY Text,publishingH Text,Department Text,ISBN Text,copies Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
        db.execSQL("Drop Table if exists Bookdetails");
    }

    public Boolean insertdata(String Bid, String Bname, String
            AuthorName, String publicationY, String publishingH, String Department, String ISBN, String copies) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Bid", Bid);
        contentValues.put("Bname", Bname);
        contentValues.put("AuthorName", AuthorName);
        contentValues.put("publicationY", publicationY);
        contentValues.put("publishingH", publishingH);
        contentValues.put("Department", Department);
        contentValues.put("ISBN", ISBN);
        contentValues.put("copies", copies);
        long result = DB.insert("Bookdetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean updatedata(String Bid, String Bname, String
            AuthorName, String publicationY, String publishingH, String Department, String
                                      ISBN, String copies) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Bid", Bid);
        contentValues.put("Bname", Bname);
        contentValues.put("AuthorName", AuthorName);
        contentValues.put("publicationY", publicationY);
        contentValues.put("publishingH", publishingH);
        contentValues.put("Department", Department);
        contentValues.put("ISBN", ISBN);
        contentValues.put("copies", copies);
        Cursor cursor = DB.rawQuery("Select * from Bookdetails where Bid=?", new String[]{String.valueOf(Bid)});
        if (cursor.getCount() > 0) {
            long result = DB.update("Bookdetails", contentValues, "Bid=?",
                    new String[]{String.valueOf(Bid)});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean deletedata(String Bid) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Bookdetails where Bid=?", new String[]{String.valueOf(Bid)});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Bookdetails", "Bid=?", new
                    String[]{String.valueOf(Bid)});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor displaydata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Bookdetails ", null);
        return cursor;
    }
}
