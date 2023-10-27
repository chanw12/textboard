package org.example;

import org.example.Controller.CommandController;
import org.example.Controller.LoginController;
import org.example.Controller.LoginRegistController;
import org.example.Controller.UserController;
import org.example.Service.CommandService;
import org.example.Service.LoginService;
import org.example.Service.UserService;

public class App {

    UserService us = new UserService();
    UserController uc = new UserController(us);
    LoginService ls = new LoginService();
    LoginController lc = new LoginController(ls);
    CommandService cs = new CommandService();
    CommandController cm = new CommandController(cs);

    LoginRegistController lrc = new LoginRegistController(uc,lc);

    private final FileInputOutput fileInputOutput = new FileInputOutput();
    public void Run(){
        fileInputOutput.FileLoad();
        lrc.loginOrRegist();
        cm.handleCommand();
        fileInputOutput.FileSave();
    }
}
