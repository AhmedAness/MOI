package com.example.moi.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moi.R;

public class DrivingLicence extends AppCompatActivity {

    Button Next;
    Button Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driving_licence);
        Inint();
        Onclick();
    }

    private void Inint() {
        Next=findViewById(R.id.Next);
        Back=findViewById(R.id.Previous);
    }

    private void Onclick() {
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DrivingLicence.this,Violations.class));
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
