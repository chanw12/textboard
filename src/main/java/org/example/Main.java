package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<FamousSaying> famousSayingList = new ArrayList<>();

        CommandHandler ch = new CommandHandler();
        FamousSayingView fv = new FamousSayingView();
        FileInputOutput.FileLoad(famousSayingList);

        fv.printinputMsg();





        FileInputOutput.FileSave();



    }
}






