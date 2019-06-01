package com.example.Assignment12;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DetailedActivity extends AppCompatActivity {
    EditText etAgentId, etAgtFirstName, etAgtMiddleInitial, etAgtLastName,
            etAgtBusPhone, etAgtEmail, etAgtPosition, etAgencyId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        etAgentId = findViewById(R.id.etAgentId);
        etAgtFirstName = findViewById(R.id.etAgtFirstName);
        etAgtMiddleInitial = findViewById(R.id.etAgtMiddleInitial);
        etAgtLastName = findViewById(R.id.etAgtLastName);
        etAgtBusPhone = findViewById(R.id.etAgtBusPhone);
        etAgtEmail = findViewById(R.id.etAgtEmail);
        etAgtPosition = findViewById(R.id.etAgtPosition);
        etAgencyId = findViewById(R.id.etAgencyId);

        Intent intent = getIntent();
        Agent agent = (Agent) intent.getSerializableExtra("agent");

        etAgentId.setText(agent.getAgentId() + "");
        etAgtFirstName.setText(agent.getAgtFirstName());
        etAgtMiddleInitial.setText(agent.getAgtMiddleInitial());
        etAgtLastName.setText(agent.getAgtLastName());
        etAgtBusPhone.setText(agent.getAgtBusPhone());
        etAgtEmail.setText(agent.getAgtEmail());
        etAgtPosition.setText(agent.getAgtPosition());
        etAgencyId.setText(agent.getAgencyId() + "");

    }
}