package org.example;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FSController {
    static FamousSayingView fv = new FamousSayingView();

    public List<FamousSaying> getRemoveFSList(List<FamousSaying> famousSayingList ,int nNum){
        famousSayingList.stream()
                .filter(fs -> fs.getId() != nNum)
                .collect(Collectors.toList());
        return famousSayingList;
    }


    public FamousSaying RegiFS(String text,String author,List<FamousSaying> famousSayingList){
        FamousSaying fs = new FamousSaying();
        fs.setAuthor(author);
        fs.setF_text(text);
        fs.setId(FamousSaying.idVal++);
        famousSayingList.add(fs);
        return fs;
    }



    public boolean CheckIdInFSList(List<FamousSaying> famousSayingList,int nNum){
        return famousSayingList.stream()
                .anyMatch(fs -> fs.getId() == nNum);
    }

    public void findModiFS(List<FamousSaying> famousSayingList, int nNum, Scanner scanner){
        famousSayingList.stream().filter(fs -> fs.getId() == nNum)
                .forEach(fs -> {
                    fv.printFamousSayingModi(fs,scanner);
                });
    }
    public List<FamousSaying> processOperation(List<FamousSaying> famousSayingList,String cmd, Scanner scanner, String Op) {
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(cmd);
        boolean found = false;
        if (matcher.find()) {
            String num = matcher.group();
            int nNum = Integer.parseInt(num);
            if (Op.equals("삭제")) {
                found = this.CheckIdInFSList(famousSayingList,nNum);
                famousSayingList = fv.printDelMsg(found,nNum,famousSayingList);
            } else if (Op.equals("수정")) {
                found = this.CheckIdInFSList(famousSayingList,nNum);
                this.findModiFS(famousSayingList,nNum,scanner);
                fv.printModiMsg(found,nNum);
            }
        }
        return famousSayingList;
    }
}
