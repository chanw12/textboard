package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<FamousSaying> famousSayingList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("명령을 입력하세요: ");
        String cmd  = scanner.next();
        while(!cmd.equals("종료")){
            if(cmd.equals("등록")){
                FamousSaying fs = new FamousSaying();
                System.out.print("명언  :  ");
                fs.text = scanner.nextLine();
                scanner.nextLine();
                System.out.print("작가  :  ");
                fs.author = scanner.nextLine();

                fs.id = FamousSaying.idVal++;
                famousSayingList.add(fs);
                System.out.println(fs.id +"번 명언이 등록되었습니다.");
                System.out.print("명령을 입력하세요: ");
                cmd  = scanner.next();
            }

        }
        return;



    }
}
