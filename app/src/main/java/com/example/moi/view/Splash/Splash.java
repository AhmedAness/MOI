package com.example.moi.view.Splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.moi.view.Login.Login;
import com.example.moi.view.MainActivity;
import com.example.moi.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                StartLogin();
            }
        }, 5000);


    }

    private void StartLogin() {
        startActivity(new Intent(this, Login.class));
    }

    private void StartMain() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
