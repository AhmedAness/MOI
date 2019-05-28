package com.example.moi.view.Server;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moi.R;
import com.example.moi.presenter.MainPresenter;
import com.example.moi.view.MainActivity;

public class ServerData extends AppCompatActivity implements IServerData{

    MainPresenter presenter;
    String message;
    EditText ServerName,PortNum;
    Button Save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_data);
        presenter=new MainPresenter(this);

        Init();
        OnClick();

//

    }


    private void Init() {
        message= getIntent().getStringExtra("message");
        Toast.makeText(this, " "+message, Toast.LENGTH_SHORT).show();

        ServerName=findViewById(R.id.ServerName);
        PortNum=findViewById(R.id.PortNumber);
        Save=findViewById(R.id.Save);
    }


    private void OnClick() {
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Validate()){
                    presenter.OnSaveServerData(ServerName.getText().toString(),PortNum.getText().toString());
                }
            }
        });
    }

    private boolean Validate() {
        if (ServerName.getText().toString().length()<3){
            ServerName.setError("Valid Item");
            return false;
        }else if (PortNum.getText().toString().length()<3){
            PortNum.setError("Valid Item");
            return false;
        }else
            return true;
    }

    @Override
    public Void OnDataFilled(String Message) {
        startActivity(new Intent(this, MainActivity.class).putExtra("message", Message));
        return null;
    }
}
