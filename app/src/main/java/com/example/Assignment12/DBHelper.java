package com.example.Assignment12;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DBHelper extends SQLiteOpenHelper {

    private static String dbName = "TravelExpertsSqlLite.db";
    private static int version = 1; // will increase in newer versions of database
    private static String dbPath = "/data/data/com.example.day12examples/databases/";
    private Context myContext;

    public DBHelper (Context myContext)
    {
        super(myContext, dbName, null, version); // factory??????????
        this.myContext = myContext;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void copyDatabase()
    {
        File dbFile = new File(dbPath + dbName);
        if (!dbFile.exists())
        {
            try {
                InputStream myInput = myContext.getAssets().open(dbName);
                OutputStream myOutput = new FileOutputStream(dbFile);
                byte [] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = myInput.read(buffer)) > 0)
                {
                    myOutput.write(buffer);
                }
                myOutput.flush();
                myOutput.close();
                myInput.close();
            } catch (IOException e) {
                e.printStackTrace( );
            }
        }
    }
}
