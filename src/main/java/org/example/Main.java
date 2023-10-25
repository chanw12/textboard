package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<FamousSaying> famousSayingList = new ArrayList<>();

        famousSayingList = FileInputOutput.FileInput(famousSayingList);

        Scanner scanner = new Scanner(System.in);
        System.out.print("명령)");
        String cmd = scanner.nextLine();
        while (!cmd.equals("종료")) {
            famousSayingList = CommandHandler.handleCommand(famousSayingList, cmd, scanner);
            System.out.print("명령)");
            cmd = scanner.nextLine();
        }
        FileInputOutput.FileOutput(famousSayingList);



    }
}






