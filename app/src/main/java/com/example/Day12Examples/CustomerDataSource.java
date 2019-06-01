package com.example.Day12Examples;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomerDataSource {
    SQLiteDatabase db;
    DBHelper helper;
    Context context;

    public CustomerDataSource(Context context) {
        this.context = context;
        helper = new DBHelper(context);
        helper.copyDatabase();
        db = helper.getWritableDatabase();

    }

    public Customer getCustomer (int customerId)
    {
        String sql = "SELECT * FROM Customers WHERE CustomerId = ?";
        String [] args = { customerId + ""};
        Cursor cursor = db.rawQuery(sql, args);
        cursor.moveToNext();
        return new Customer(cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7),
                cursor.getString(8),
                cursor.getString(9),
                cursor.getString(10),
                cursor.getInt(11));
    }


    public ArrayList<Customer> getAllCustomers()
    {
        ArrayList<Customer> list = new ArrayList<>();

        String sql = "SELECT * FROM Customers";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext())
        {
            list.add(new Customer(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getInt(11)));
        }
        return list;
    }


    public void insertCustomer (Customer cust)
    {
        ContentValues values = new ContentValues();

        values.put("customerID", cust.getCustomerID()); // auto-increment???????????????????
        values.put("CustFirstName", cust.getCustFirstName());
        values.put("CustLastName", cust.getCustLastName());
        values.put("CustAddress", cust.getCustAddress());
        values.put("CustCity", cust.getCustCity());
        values.put("CustProv", cust.getCustProv());
        values.put("CustPostal", cust.getCustPostal());
        values.put("CustCountry", cust.getCustCountry());
        values.put("CustHomePhone", cust.getCustHomePhone());
        values.put("CustBusPhone", cust.getCustBusPhone());
        values.put("CustEmail", cust.getCustEmail());
        values.put("AgentId", cust.getAgentId());

        long rowsInserted = db.insert("Customers", null, values);
        if (rowsInserted == 0)
        {
            Toast.makeText(context, "Insert failed!", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(context, "Inserted successfully!", Toast.LENGTH_LONG).show();
        }
    }


    public void updateCustomer (Customer newCust)
    {
        ContentValues values = new ContentValues();

        values.put("CustFirstName", newCust.getCustFirstName());
        values.put("CustLastName", newCust.getCustLastName());
        values.put("CustAddress", newCust.getCustAddress());
        values.put("CustCity", newCust.getCustCity());
        values.put("CustProv", newCust.getCustProv());
        values.put("CustPostal", newCust.getCustPostal());
        values.put("CustCountry", newCust.getCustCountry());
        values.put("CustHomePhone", newCust.getCustHomePhone());
        values.put("CustBusPhone", newCust.getCustBusPhone());
        values.put("CustEmail", newCust.getCustEmail());
        values.put("AgentId", newCust.getAgentId());

        String [] args = {newCust.getCustomerID() + ""};
        long rowsUpdated = db.update("Customers", values,
                "CustomerId=?", args);
        if (rowsUpdated == 0)
        {
            Toast.makeText(context, "Update failed!", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(context, "Updated successfully!", Toast.LENGTH_LONG).show();
        }
    }


    public void deleteCustomer (Customer cust)
    {
        String [] args = {cust.getCustomerID() + ""};
        int rowsDeleted = db.delete("Customers", "CustomerId=?", args);
//        db.delete("Customers", "CustomerID()=" + cust.getCustomerID); // doesn't work

        if (rowsDeleted == 0)
        {
            Toast.makeText(context, "Delete failed!", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(context, "Deleted successfully!", Toast.LENGTH_LONG).show();
        }

    }
}
