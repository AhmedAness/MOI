package com.example.moi.presenter;

import com.example.moi.model.User;

public interface IMainPresenter {

    void OnLogin(User user);
    void OnSaveServerData(String ServerName,String PortNum);

}
