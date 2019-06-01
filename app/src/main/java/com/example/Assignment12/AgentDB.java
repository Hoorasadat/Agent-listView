package com.example.Assignment12;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class AgentDB {

    DBHelper helper;
    SQLiteDatabase db;
    Context context;

    public AgentDB(Context context)
    {
        this.context = context;
        helper = new DBHelper(context);
        helper.copyDatabase();
        db = helper.getReadableDatabase();
//        db = helper.getWritableDatabase();
    }


    public ArrayList<Agent> getAllAgents()
    {
        ArrayList<Agent> list = new ArrayList<Agent>();
        String sql = "SELECT * FROM Agents";
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext())
        {
            list.add(new Agent(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getInt(7)));
        }
        return list;
    }



}