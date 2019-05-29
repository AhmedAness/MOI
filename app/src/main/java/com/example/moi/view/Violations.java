package com.example.moi.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.moi.R;

import java.util.ArrayList;
import java.util.List;

public class Violations extends AppCompatActivity {

    Button Next;
    Button Back;
    Spinner spinner_Issuer;
    List <String> spinnerarray = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_violations);
        Inint();
        Onclick();
    }

    private void Inint() {
        spinnerarray.add("سحب رخصه");
        spinnerarray.add("تصالح");

        Next=findViewById(R.id.Next);
        Back=findViewById(R.id.Previous);
        spinner_Issuer=findViewById(R.id.spinner_Issuer);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, spinnerarray);//setting the country_array to spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_Issuer.setAdapter(adapter);
    }

    private void Onclick() {
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinner_Issuer.getSelectedItemId() == 0) {
                    startActivity(new Intent(Violations.this,WithdrawalLicence.class));
                }else {
                    startActivity(new Intent(Violations.this,Reconciliation.class));
                }
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
