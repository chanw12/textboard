package org.example;

public class CommandHandler {
    FamousSayingView fv = new FamousSayingView();
    FSController fc = new FSController();

    public void handleCommand(){
        String cmd = Context.scanner.nextLine();
        while (!cmd.equals("종료")) {
            if(cmd.equals("등록")){
                fv.printFamousSayingRegi();
            }else if(cmd.equals("목록")){
                fv.printFamousSayingDetail();
            }else if (cmd.contains("삭제")||cmd.contains("수정")){
                String op =  cmd.contains("삭제")?"삭제":"수정";
                fc.processOperation(cmd,op);
            }
            fv.printinputMsg();
            cmd = Context.scanner.nextLine();
        }

    }


}
