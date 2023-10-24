package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("명령을 입력하세요: ");
        String cmd  = scanner.next();
        if(cmd == "종료"){
            return;
        }

    }
}