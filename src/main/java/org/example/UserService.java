package org.example;

public  class UserService {
    static UserService us = new UserService();
    public boolean checkIsAlreadyIn(String id){
        return Context.userList.stream().anyMatch(i->i.id==id);
    }
    public void RegisUser(String id,String pwd){
        Context.userList.add(new User(id,pwd));

    }
}
