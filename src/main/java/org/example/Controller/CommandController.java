package org.example.Controller;

import org.example.Service.CommandService;
import org.example.Context;
import org.example.FamousSaying;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandController {
    private final CommandService cs;
    private final Context context = Context.getInstance();
    public CommandController(CommandService cs){
        this.cs = cs;
    }

    public void handleCommand(){
        printinputMsg();
        String cmd = context.getScanner().nextLine();
        while (!cmd.equals("종료")) {
            if(cmd.equals("등록")){
                printFamousSayingRegi();
            }else if(cmd.equals("목록")){
                printFamousSayingDetail();
            }else if (cmd.startsWith("삭제")||cmd.startsWith("수정")){
                String op =  cmd.contains("삭제")?"삭제":"수정";
                processOperation(cmd,op);
            }
            printinputMsg();
            cmd = context.getScanner().nextLine();
        }

    }



    public void printFamousSayingRegi(){

        System.out.print("명언  :  ");
        String text = context.getScanner().nextLine();
        System.out.print("작가  :  ");
        String author = context.getScanner().nextLine();
        FamousSaying fs = cs.RegiFS(text,author);
        System.out.println(fs.getId() +"번 명언이 등록되었습니다.");

    }


    public void printFamousSayingDetail(){
        System.out.println("번호  /  작가  /  명언");
        System.out.println("--------------------");
        context.getFamousSayingList().stream().forEach(f->System.out.println(f.getId() + "  /  " +f.getAuthor() + "  /  " +f.getF_text()));
    }

    public void processOperation(String cmd, String Op) {
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(cmd);
        boolean found = false;
        if (matcher.find()) {
            String num = matcher.group();
            int nNum = Integer.parseInt(num);
            if (Op.equals("삭제")) {
                found = cs.CheckIdInFSList(nNum);
                printDelMsg(found,nNum);
            } else if (Op.equals("수정")) {
                found = cs.CheckIdInFSList(nNum);
                printFamousSayingModi(cs.findModiFS(nNum));
                printModiMsg(found,nNum);
            }
        }
    }

    public void printinputMsg(){
        System.out.print("명령)");
    }

    public void printModiMsg(boolean found,int nNum){
        if (!found) {
            System.out.println(nNum + "번 명언은 존재하지 않습니다.");
        } else {
            System.out.println(nNum + "번 명언이 수정되었습니다.");
        }
    }

    public void printFamousSayingModi(FamousSaying fs){
        String text;
        String author;
        System.out.println("명언(기존) : " + fs.getF_text());
        System.out.print("명언  :  ");
        text = context.getScanner().nextLine();

        System.out.println("작가(기존)  :  " + fs.getAuthor());
        System.out.print("작가  :  ");
        author = context.getScanner().nextLine();
        cs.setModi(text,author,fs);
    }

    public void printDelMsg(boolean found,int nNum){
        if (!found) {
            System.out.println(nNum + "번 명언은 존재하지 않습니다.");
        } else {
            cs.getRemoveFSList(nNum);
            System.out.println(nNum + "번 명언이 삭제되었습니다.");
        }
    }



}
