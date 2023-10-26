package org.example.Service;

import org.example.Context;
import org.example.FamousSaying;

import java.util.stream.Collectors;

public class CommandService {
    private final Context context = Context.getInstance();
    public CommandService(){

    }

    public void setModi(String text, String author, FamousSaying fs){
        fs.setF_text(text);
        fs.setAuthor(author);

    }

    public void getRemoveFSList(int nNum){
        context.setFamousSayingList(context.getFamousSayingList().stream()
                .filter(fs -> fs.getId() != nNum)
                .collect(Collectors.toList()));

    }


    public FamousSaying RegiFS(String text,String author){
        FamousSaying fs = new FamousSaying();
        fs.setAuthor(author);
        fs.setF_text(text);
        fs.setId(FamousSaying.idVal++);
        context.getFamousSayingList().add(fs);
        return fs;
    }



    public boolean CheckIdInFSList(int nNum){
        return context.getFamousSayingList().stream()
                .anyMatch(fs -> fs.getId() == nNum);
    }

    public FamousSaying findModiFS(int nNum){
        return context.getFamousSayingList().stream().filter(fs -> fs.getId() == nNum).findFirst().orElse(null);
    }



}
