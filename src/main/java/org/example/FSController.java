package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FSController {
    static FamousSayingView fv = new FamousSayingView();

    public void getRemoveFSList(int nNum){
        Context.famousSayingList = Context.famousSayingList.stream()
                .filter(fs -> fs.getId() != nNum)
                .collect(Collectors.toList());

    }


    public FamousSaying RegiFS(String text,String author){
        FamousSaying fs = new FamousSaying();
        fs.setAuthor(author);
        fs.setF_text(text);
        fs.setId(FamousSaying.idVal++);
        Context.famousSayingList.add(fs);
        return fs;
    }



    public boolean CheckIdInFSList(int nNum){
        return Context.famousSayingList.stream()
                .anyMatch(fs -> fs.getId() == nNum);
    }

    public void findModiFS(int nNum){
        Context.famousSayingList.stream().filter(fs -> fs.getId() == nNum)
                .forEach(fs -> {
                    fv.printFamousSayingModi(fs);
                });
    }
    public void processOperation(String cmd, String Op) {
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(cmd);
        boolean found = false;
        if (matcher.find()) {
            String num = matcher.group();
            int nNum = Integer.parseInt(num);
            if (Op.equals("삭제")) {
                found = this.CheckIdInFSList(nNum);
                fv.printDelMsg(found,nNum);
            } else if (Op.equals("수정")) {
                found = this.CheckIdInFSList(nNum);
                this.findModiFS(nNum);
                fv.printModiMsg(found,nNum);
            }
        }
    }
}
