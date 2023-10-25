package org.example;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FamousSayingView {

    public static void printFamousSayingModi(FamousSaying fs, Scanner scanner){
        System.out.println("명언(기존) : " + fs.getF_text());
        System.out.print("명언  :  ");
        fs.setF_text(scanner.nextLine());
        System.out.println("작가(기존)  :  " + fs.getAuthor());
        System.out.print("작가  :  ");
        fs.setAuthor(scanner.nextLine());
    }

    public static void printFamousSayingDetail(List<FamousSaying> famousSayingList){
        System.out.println("번호  /  작가  /  명언");
        System.out.println("--------------------");
        famousSayingList.stream().forEach(f->System.out.println(f.id + "  /  " +f.author + "  /  " +f.f_text));
    }

    public static void printModiMsg(boolean found,int nNum){
        if (!found) {
            System.out.println(nNum + "번 명언은 존재하지 않습니다.");
        } else {
            System.out.println(nNum + "번 명언이 수정되었습니다.");
        }
    }

    public static List<FamousSaying> printDelMsg(boolean found,int nNum,List<FamousSaying> famousSayingList){
        if (!found) {
            System.out.println(nNum + "번 명언은 존재하지 않습니다.");
        } else {
            famousSayingList = famousSayingList.stream()
                    .filter(fs -> fs.getId() != nNum)
                    .collect(Collectors.toList());
            System.out.println(nNum + "번 명언이 삭제되었습니다.");
        }
        return famousSayingList;
    }

}
