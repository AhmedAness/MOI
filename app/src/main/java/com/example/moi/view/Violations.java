package com.example.moi.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.moi.R;
import com.example.moi.view.Adapter.Violation_List_Adapter;

import java.util.ArrayList;
import java.util.List;

public class Violations extends AppCompatActivity implements Violation_List_Adapter.ItemClickListener{

    Button Next,Back;
    Spinner spinner_Issuer;
    EditText ViolationCount;
    List <String> spinnerarray = new ArrayList<>();
    Violation_List_Adapter violation_adapter;
    // data to populate the RecyclerView with
    ArrayList<String> ViolationsNames = new ArrayList<>();
    RecyclerView recyclerView;
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


        ViolationsNames.add("القياده عكس الطريق");
        ViolationsNames.add("مخالفه الاشاره");
        ViolationsNames.add("القياده بسرعه مخالفه");
        ViolationsNames.add("اصطدام بممتلكات عامه");

        // set up the RecyclerView
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        violation_adapter = new Violation_List_Adapter(this, ViolationsNames);
        violation_adapter.setClickListener(this);
        recyclerView.setAdapter(violation_adapter);

        ViolationCount=findViewById(R.id.ViolationCount);
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

    @Override
    public void onSelectViolation( List<String>  SelectedItems) {
        ViolationCount.setText(SelectedItems.size()+"");
//        Toast.makeText(this, "You clicked " + violation_adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}
