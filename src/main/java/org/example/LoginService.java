package org.example;

public class LoginService {
    static LoginService ls = new LoginService();

    public boolean checkCanLogin(String id,String pwd){
        return Context.userList.stream().anyMatch(i->i.id.equals(id) & i.pwd.equals(pwd));
    }
}
