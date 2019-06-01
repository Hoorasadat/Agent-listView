package com.example.Day12Examples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    ListView lvCustomers;
    ArrayAdapter<Customer> arrayAdapter;
    CustomerDataSource source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        source = new CustomerDataSource(this);
        lvCustomers = findViewById(R.id.lvCustomers);
        arrayAdapter = new ArrayAdapter<Customer>(this,
                                                    android.R.layout.simple_list_item_1,
                                                    source.getAllCustomers());
        lvCustomers.setAdapter(arrayAdapter);



        lvCustomers.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), DetailedActivity.class);
                intent.putExtra("customer",
                                      (Serializable) lvCustomers.getItemAtPosition(position));

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        arrayAdapter.clear();
        arrayAdapter.addAll(source.getAllCustomers());
    }

    @Override
    protected void onResume() {
        super.onResume();

        arrayAdapter.clear();
        arrayAdapter.addAll(source.getAllCustomers());
    }
}
