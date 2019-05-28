package com.example.moi.view;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.moi.R;

public class MainActivity extends AppCompatActivity {

    String message;
    ConstraintLayout violation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();

        OnClick();

        message= getIntent().getStringExtra("message");
        Toast.makeText(this, " "+message, Toast.LENGTH_SHORT).show();
    }

    private void Init() {
        violation=findViewById(R.id.violation);
    }

    private void OnClick() {
        violation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartVioation();
            }
        });
    }

    private void StartVioation() {
        startActivity(new Intent(this, CarInfo.class));
    }

}
