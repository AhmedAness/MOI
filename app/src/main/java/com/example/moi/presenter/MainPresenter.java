package com.example.moi.presenter;

import com.example.moi.model.User;
import com.example.moi.view.Login.ILogin;
import com.example.moi.view.Server.IServerData;
import com.example.moi.view.Splash.ISplash;

public class MainPresenter implements IMainPresenter{

    ILogin ilogin;
    ISplash iSplash;
    IServerData iServerData;

    public MainPresenter(ILogin ilogin) {
        this.ilogin=ilogin;
    }
    public MainPresenter(ISplash iSplash) {
        this.iSplash=iSplash;
    }
    public MainPresenter(IServerData iServerData) {
        this.iServerData=iServerData;
    }

    @Override
    public void OnLogin(User user) {
        //do my Action then call result
        ilogin.OnLoginResult("Welcome");
    }

    @Override
    public void OnSaveServerData(String ServerName, String PortNum) {
        iServerData.OnDataFilled("Saved");
    }
}
