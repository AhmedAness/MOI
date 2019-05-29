package com.example.moi.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moi.R;

public class Reconciliation extends AppCompatActivity {

    Button Print;
    Button Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reconciliation);
        Init();
        OnClick();
    }


    private void Init() {
        Print=findViewById(R.id.Print);
        Back=findViewById(R.id.Previous);
    }

    private void OnClick() {
        Print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
