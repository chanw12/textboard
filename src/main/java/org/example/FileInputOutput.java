package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;

public class FileInputOutput {
    Context context = Context.getInstance();
    static ObjectMapper mapper = new ObjectMapper();
    public void FileLoad(){

        try {
            context.setFamousSayingList(new ArrayList<>(Arrays.asList(mapper.readValue(new File("data.json"), FamousSaying[].class))));
            context.setUserList(new ArrayList<>(Arrays.asList(mapper.readValue(new File("user.json"),User[].class))));
            OptionalInt maxId = context.getFamousSayingList().stream().mapToInt(fs -> fs.getId()).max();
            if (maxId.isPresent()) {
                FamousSaying.idVal = maxId.getAsInt() + 1;
            }

        } catch (IOException ex) {
            System.out.println("파일 읽기 오류: " + ex.getMessage());
        }
    }

    public void FileSave(){
        try {
            mapper.writeValue(new File("user.json"),context.getUserList());
            mapper.writeValue(new File("data.json"), context.getFamousSayingList());
            System.out.println("파일 저장 성공");
        } catch (IOException ex) {
            System.out.println("파일 쓰기 오류" + ex.getMessage());
        }
    }
}
