package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<FamousSaying> famousSayingList = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        try {
            famousSayingList = new ArrayList<>(Arrays.asList(mapper.readValue(new File("data.json"), FamousSaying[].class)));
            OptionalInt maxId = famousSayingList.stream().mapToInt(fs -> fs.getId()).max();
            if (maxId.isPresent()) {
                FamousSaying.idVal = maxId.getAsInt() + 1;
            }

        } catch (IOException ex) {
            System.out.println("파일 읽기 오류: " + ex.getMessage());
        }



        Scanner scanner = new Scanner(System.in);
        System.out.print("명령)");
        String cmd = scanner.nextLine();
        while (!cmd.equals("종료")) {
            famousSayingList = CommandHandler.handleCommand(famousSayingList, cmd, scanner);
            System.out.print("명령)");
            cmd = scanner.nextLine();
        }




        try {
            mapper.writeValue(new File("data.json"), famousSayingList);
            System.out.println("파일 저장 성공");
        } catch (IOException ex) {
            System.out.println("파일 쓰기 오류" + ex.getMessage());
        }

        return;
    }
}






