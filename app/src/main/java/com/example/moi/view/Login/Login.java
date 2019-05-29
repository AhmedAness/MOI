package com.example.moi.view.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.moi.R;
import com.example.moi.model.User;
import com.example.moi.presenter.MainPresenter;
import com.example.moi.view.Server.ServerData;

public class Login extends AppCompatActivity  implements ILogin {

    MainPresenter presenter;

    EditText Name;
    EditText Password;
    Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter=new MainPresenter(this);

        Init();

        OnClick();

//        presenter.OnLogin("ahmed","123");
    }


    private void Init() {
        Name = findViewById(R.id.Name);
        Password = findViewById(R.id.Password);
        Login = findViewById(R.id.Login);
    }

    private void OnClick() {
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Validate()){
                    presenter.OnLogin(new User(Name.getText().toString(),Password.getText().toString()));
                }
            }
        });
    }

    private boolean Validate() {
        if (Name.getText().toString().length()<3){
            Name.setError("Valid Item");
            return false;
        }else if (Password.getText().toString().length()<3){
            Password.setError("Valid Item");
            return false;
        }else
            return true;
    }

    private void StartMain(String message) {
        startActivity(new Intent(this, ServerData.class).putExtra("message", message));
    }

    @Override
    public Void OnLoginResult(String message) {
        StartMain(message);
        return null;
    }
}
