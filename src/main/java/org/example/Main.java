package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        List<FamousSaying> famousSayingList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("명령)");
        String cmd  = scanner.nextLine();
        while(!cmd.equals("종료")){
            if(cmd.equals("등록")){
                FamousSaying fs = new FamousSaying();
                System.out.print("명언  :  ");
                fs.f_text = scanner.nextLine();
                System.out.print("작가  :  ");
                fs.author = scanner.nextLine();

                fs.id = FamousSaying.idVal++;
                famousSayingList.add(fs);

                System.out.println(fs.id +"번 명언이 등록되었습니다.");
                System.out.print("명령)");
                cmd  = scanner.nextLine();
            }
            else if(cmd.equals("목록")){
                System.out.println("번호  /  작가  /  명언");
                System.out.println("--------------------");

                for(FamousSaying f:famousSayingList){
                    System.out.println(f.id + "  /  " +f.author + "  /  " +f.f_text);
                }

                System.out.print("명령)");
                cmd  = scanner.nextLine();
            }
            else if(cmd.contains("삭제")){
                Pattern pattern = Pattern.compile("(\\d+)");
                Matcher matcher = pattern.matcher(cmd);
                boolean found = false;
                if(matcher.find()){
                    String num = matcher.group();
                    int nNum = Integer.parseInt(num);
                    for(int k =0;k<famousSayingList.size();k++){
                        if(famousSayingList.get(k).id == nNum){
                            famousSayingList.remove(k);
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        System.out.println(nNum+"번 명언은 존재하지 않습니다.");
                    }else{
                        System.out.println(nNum+ "번 명언이 삭제되었습니다.");
                    }

                }
                System.out.print("명령)");
                cmd  = scanner.nextLine();
            }

        }
        return;



    }
}
