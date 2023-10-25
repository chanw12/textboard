package org.example;

import java.util.List;
import java.util.Scanner;

public class CommandHandler {
    FamousSayingView fv = new FamousSayingView();
    FSController fc = new FSController();

    public List<FamousSaying> handleCommand(List <FamousSaying> famousSayingList, String cmd){
        if(cmd.equals("등록")){
            fv.printFamousSayingRegi(famousSayingList);
        }else if(cmd.equals("목록")){
            fv.printFamousSayingDetail(famousSayingList);
        }else if (cmd.contains("삭제")||cmd.contains("수정")){
            String op =  cmd.contains("삭제")?"삭제":"수정";
            famousSayingList = fc.processOperation(famousSayingList,cmd,op);
        }
        return famousSayingList;
    }


}
