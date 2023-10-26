package org.example.Service;

import org.example.Context;

public class LoginService {

    public LoginService(){

    }

    private final Context context = Context.getInstance();

    public boolean checkCanLogin(String id,String pwd){
        return context.getUserList().stream().anyMatch(i->i.getId().equals(id) & i.getPwd().equals(pwd));
    }
}
