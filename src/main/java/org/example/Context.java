package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Context {
    private static Context instance = null;
    private Scanner scanner;
    private List<FamousSaying> famousSayingList ;
    private Paging<FamousSaying> famousSayingPaging;
    private List<User> userList;
    private Paging<User> userPaging;
    private Boolean logincheck;
    private Context() {
        scanner = new Scanner(System.in);
        famousSayingList = new ArrayList<>();
        userList = new ArrayList<>();
        logincheck = false;
        famousSayingPaging = new Paging<>(famousSayingList,5);
    }

    public static Context getInstance(){
        if(instance==null){
            instance = new Context();
        }
        return instance;
    }



    public Scanner getScanner() {
        return scanner;
    }

    public List<FamousSaying> getFamousSayingList() {
        return famousSayingList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public  void setFamousSayingList(List<FamousSaying> famousSayingList) {
        this.famousSayingList = famousSayingList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Boolean getLogincheck() {
        return logincheck;
    }

    public void setLogincheck(Boolean logincheck) {
        this.logincheck = logincheck;
    }
    public void closeScanner(){
        scanner.close();
    }
}
