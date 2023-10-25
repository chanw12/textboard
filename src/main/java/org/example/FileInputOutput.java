package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class FileInputOutput {
    static ObjectMapper mapper = new ObjectMapper();
    public static List<FamousSaying> FileInput(List<FamousSaying> famousSayingList){

        try {
            famousSayingList = new ArrayList<>(Arrays.asList(mapper.readValue(new File("data.json"), FamousSaying[].class)));
            OptionalInt maxId = famousSayingList.stream().mapToInt(fs -> fs.getId()).max();
            if (maxId.isPresent()) {
                FamousSaying.idVal = maxId.getAsInt() + 1;
            }

        } catch (IOException ex) {
            System.out.println("파일 읽기 오류: " + ex.getMessage());
        }
        return famousSayingList;
    }

    public static void FileOutput(List<FamousSaying> famousSayingList){
        try {
            mapper.writeValue(new File("data.json"), famousSayingList);
            System.out.println("파일 저장 성공");
        } catch (IOException ex) {
            System.out.println("파일 쓰기 오류" + ex.getMessage());
        }
    }
}
