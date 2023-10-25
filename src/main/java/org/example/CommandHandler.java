package org.example;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
            System.out.println("번호  /  작가  /  명언");
            System.out.println("--------------------");

            famousSayingList.stream().forEach(f->System.out.println(f.id + "  /  " +f.author + "  /  " +f.f_text));

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

                famousSayingList = famousSayingList.stream()
                        .filter(fs -> fs.getId() != nNum)
                        .collect(Collectors.toList());

                if (!found) {
                    System.out.println(nNum + "번 명언은 존재하지 않습니다.");
                } else {
                    System.out.println(nNum + "번 명언이 삭제되었습니다.");
                }
            } else if (Op.equals("수정")) {
                found = famousSayingList.stream()
                        .anyMatch(fs -> fs.getId() == nNum);
                famousSayingList.stream().filter(fs -> fs.getId() == nNum)
                        .forEach(fs -> {
                            System.out.println("명언(기존) : " + fs.getF_text());
                            System.out.print("명언  :  ");
                            fs.setF_text(scanner.nextLine());
                            System.out.println("작가(기존)  :  " + fs.getAuthor());
                            System.out.print("작가  :  ");
                            fs.setAuthor(scanner.nextLine());
                        });

                if (!found) {
                    System.out.println(nNum + "번 명언은 존재하지 않습니다.");
                } else {
                    System.out.println(nNum + "번 명언이 수정되었습니다.");
                }


            }
        }
    return famousSayingList;
    }

}
