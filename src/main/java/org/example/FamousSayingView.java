package org.example;

import java.util.List;

public class FamousSayingView {
    FSController fc = new FSController();

    public List<FamousSaying> printFamousSayingRegi( List<FamousSaying> famousSayingList){

        System.out.print("명언  :  ");
        String text = Context.scanner.nextLine();
        System.out.print("작가  :  ");
        String author = Context.scanner.nextLine();
        FamousSaying fs = fc.RegiFS(text,author,famousSayingList);
        System.out.println(fs.id +"번 명언이 등록되었습니다.");
        return famousSayingList;
    }

    public void printFamousSayingModi(FamousSaying fs){

        System.out.println("명언(기존) : " + fs.getF_text());
        System.out.print("명언  :  ");
        fs.setF_text(Context.scanner.nextLine());
        System.out.println("작가(기존)  :  " + fs.getAuthor());
        System.out.print("작가  :  ");
        fs.setAuthor(Context.scanner.nextLine());
    }

    public void printFamousSayingDetail(List<FamousSaying> famousSayingList){
        System.out.println("번호  /  작가  /  명언");
        System.out.println("--------------------");
        famousSayingList.stream().forEach(f->System.out.println(f.id + "  /  " +f.author + "  /  " +f.f_text));
    }

    public void printModiMsg(boolean found,int nNum){
        if (!found) {
            System.out.println(nNum + "번 명언은 존재하지 않습니다.");
        } else {
            System.out.println(nNum + "번 명언이 수정되었습니다.");
        }
    }

    public List<FamousSaying> printDelMsg(boolean found,int nNum,List<FamousSaying> famousSayingList){
        if (!found) {
            System.out.println(nNum + "번 명언은 존재하지 않습니다.");
        } else {
            famousSayingList = fc.getRemoveFSList(famousSayingList,nNum);
            System.out.println(nNum + "번 명언이 삭제되었습니다.");
        }
        return famousSayingList;
    }

    public void printinputMsg(){
        System.out.print("명령)");
    }

}
