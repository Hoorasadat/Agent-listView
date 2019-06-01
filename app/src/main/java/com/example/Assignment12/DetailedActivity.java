package com.example.Assignment12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.Assignment12.R;

public class DetailedActivity extends AppCompatActivity {

    TextView etcustomerID, etCustFirstName, etCustLastName, etCustAddress, etCustCity,etCustProv,
            etCustPostal, etCustCountry, etCustHomePhone, etCustBusPhone, etCustEmail, etAgentId;

    Button btnUpdate, btnDelete;

    Customer c;
    CustomerDataSource source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        etcustomerID = findViewById(R.id.etcustomerID);
        etCustFirstName = findViewById(R.id.etCustFirstName);
        etCustLastName = findViewById(R.id.etCustLastName);
        etCustAddress = findViewById(R.id.etCustAddress);
        etCustCity = findViewById(R.id.etCustCity);
        etCustProv = findViewById(R.id.etCustProv);
        etCustPostal = findViewById(R.id.etCustPostal);
        etCustCountry = findViewById(R.id.etCustCountry);
        etCustHomePhone = findViewById(R.id.etCustHomePhone);
        etCustBusPhone = findViewById(R.id.etCustBusPhone);
        etCustEmail = findViewById(R.id.etCustEmail);
        etAgentId = findViewById(R.id.etAgentId);

        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);

        c = (Customer) getIntent().getSerializableExtra("customer");
        etcustomerID.setText(c.getCustomerID() + "");
        etCustFirstName.setText(c.getCustFirstName());
        etCustLastName.setText(c.getCustLastName());
        etCustAddress.setText(c.getCustAddress());
        etCustCity.setText(c.getCustCity());
        etCustProv.setText(c.getCustProv());
        etCustPostal.setText(c.getCustPostal());
        etCustCountry.setText(c.getCustCountry());
        etCustHomePhone.setText(c.getCustHomePhone());
        etCustBusPhone.setText(c.getCustBusPhone());
        etCustEmail.setText(c.getCustEmail());
        etAgentId.setText(c.getAgentId() + "");


        source = new CustomerDataSource(this);


        btnUpdate.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                source.updateCustomer(new Customer(
                        Integer.parseInt(etcustomerID.getText().toString()),
                        etCustFirstName.getText().toString(),
                        etCustLastName.getText().toString(),
                        etCustAddress.getText().toString(),
                        etCustCity.getText().toString(),
                        etCustProv.getText().toString(),
                        etCustPostal.getText().toString(),
                        etCustCountry.getText().toString(),
                        etCustHomePhone.getText().toString(),
                        etCustBusPhone.getText().toString(),
                        etCustEmail.getText().toString(),
                        Integer.parseInt(etAgentId.getText().toString())));
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                source.deleteCustomer(c);
            }
        });
    }
}
