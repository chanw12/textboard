package org.example;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandHandler {

    public static List<FamousSaying> handleCommand(List <FamousSaying> famousSayingList, String cmd,Scanner scanner){
        if(cmd.equals("등록")){
            FamousSaying fs = new FamousSaying();
            System.out.print("명언  :  ");
            fs.f_text = scanner.nextLine();
            System.out.print("작가  :  ");
            fs.author = scanner.nextLine();
            fs.setId(FamousSaying.idVal++);
            famousSayingList.add(fs);

            System.out.println(fs.id +"번 명언이 등록되었습니다.");

        }else if(cmd.equals("목록")){
            FamousSayingView.printFamousSayingDetail(famousSayingList);

        }else if (cmd.contains("삭제")||cmd.contains("수정")){
            String op =  cmd.contains("삭제")?"삭제":"수정";
            famousSayingList = processOperation(famousSayingList,cmd,scanner,op);
        }
        return famousSayingList;
    }
    private static List<FamousSaying> processOperation(List<FamousSaying> famousSayingList,String cmd, Scanner scanner, String Op) {
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(cmd);
        boolean found = false;
        if (matcher.find()) {
            String num = matcher.group();
            int nNum = Integer.parseInt(num);
            if (Op.equals("삭제")) {
                found = famousSayingList.stream()
                        .anyMatch(fs -> fs.getId() == nNum);
                famousSayingList = FamousSayingView.printDelMsg(found,nNum,famousSayingList);



            } else if (Op.equals("수정")) {
                found = famousSayingList.stream()
                        .anyMatch(fs -> fs.getId() == nNum);
                famousSayingList.stream().filter(fs -> fs.getId() == nNum)
                        .forEach(fs -> {
                            FamousSayingView.printFamousSayingModi(fs,scanner);
                        });

                FamousSayingView.printModiMsg(found,nNum);


            }
        }
    return famousSayingList;
    }

}
