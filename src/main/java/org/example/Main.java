package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<FamousSaying> famousSayingList = new ArrayList<>();
        famousSayingList = FileInputOutput.FileInput(famousSayingList);
        CommandHandler ch = new CommandHandler();
        Scanner scanner = new Scanner(System.in);
        FamousSayingView fv = new FamousSayingView();

        fv.printinputMsg();
        String cmd = scanner.nextLine();
        while (!cmd.equals("종료")) {
            famousSayingList = ch.handleCommand(famousSayingList, cmd, scanner);
            fv.printinputMsg();
            cmd = scanner.nextLine();
        }



        FileInputOutput.FileOutput(famousSayingList);



    }
}






