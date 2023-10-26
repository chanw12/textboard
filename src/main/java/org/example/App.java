package org.example;

public class App {

    CommandHandler cm = new CommandHandler();
    LoginRegistController lc = new LoginRegistController();
    public void Run(){

        FileInputOutput.FileLoad();
        lc.loginOrRegist();
        cm.handleCommand();
        FileInputOutput.FileSave();
    }
}
