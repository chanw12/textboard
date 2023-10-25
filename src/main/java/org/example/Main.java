package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<FamousSaying> famousSayingList = new ArrayList<>();
        famousSayingList = FileInputOutput.FileInput(famousSayingList);
        CommandHandler ch = new CommandHandler();
        FamousSayingView fv = new FamousSayingView();

        fv.printinputMsg();

        String cmd = Context.scanner.nextLine();
        while (!cmd.equals("종료")) {
            famousSayingList = ch.handleCommand(famousSayingList, cmd);
            fv.printinputMsg();
            cmd = Context.scanner.nextLine();
        }



        FileInputOutput.FileOutput(famousSayingList);



    }
}






