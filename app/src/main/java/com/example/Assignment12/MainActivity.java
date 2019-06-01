package com.example.Assignment12;

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
    ArrayAdapter<Agent> arrayAdapter;
    AgentDB source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        source = new AgentDB(this);
        lvCustomers = findViewById(R.id.lvCustomers);
        arrayAdapter = new ArrayAdapter<Agent>(this,
                                                    android.R.layout.simple_list_item_1,
                                                    source.getAllAgents());
        lvCustomers.setAdapter(arrayAdapter);



        lvCustomers.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), DetailedActivity.class);
                intent.putExtra("agent",
                                      (Serializable) lvCustomers.getItemAtPosition(position));

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        arrayAdapter.clear();
        arrayAdapter.addAll(source.getAllAgents());
    }

    @Override
    protected void onResume() {
        super.onResume();

        arrayAdapter.clear();
        arrayAdapter.addAll(source.getAllAgents());
    }
}
