package org.example.Service;

import org.example.Context;
import org.example.User;

public  class UserService {
    private final Context context= Context.getInstance();

    public UserService(){

    }

    public boolean checkIsAlreadyIn(String id){
        return context.getUserList().stream().anyMatch(i->i.getId()==id);
    }
    public void RegisUser(String id,String pwd){
        context.getUserList().add(new User(id,pwd));

    }
}
