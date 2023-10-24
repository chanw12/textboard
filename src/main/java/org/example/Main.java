package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        List<FamousSaying> famousSayingList = new ArrayList<>();


//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.txt"))) {
//            famousSayingList = (List<FamousSaying>) ois.readObject();
//            // 읽은 리스트를 사용하는 코드
//            for (FamousSaying fs : famousSayingList) {
//                FamousSaying.idVal++;
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("파일 읽기 오류: " + e.getMessage());
//        }

        ObjectMapper mapper = new ObjectMapper();
        try{
            famousSayingList = new ArrayList<>(Arrays.asList( mapper.readValue(new File("data.json"), FamousSaying[].class)));

            for(FamousSaying ff:famousSayingList){
                FamousSaying.idVal++;
            }
        }catch (IOException ex){
            System.out.println("파일 읽기 오류: " + ex.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("명령)");
        String cmd  = scanner.nextLine();
        while(!cmd.equals("종료")){
            if(cmd.equals("등록")){
                FamousSaying fs = new FamousSaying();
                System.out.print("명언  :  ");
                fs.f_text = scanner.nextLine();
                System.out.print("작가  :  ");
                fs.author = scanner.nextLine();

                fs.setId(FamousSaying.idVal++);
                famousSayingList.add(fs);

                System.out.println(fs.id +"번 명언이 등록되었습니다.");
                System.out.print("명령)");
                cmd  = scanner.nextLine();
            }
            else if(cmd.equals("목록")){
                System.out.println("번호  /  작가  /  명언");
                System.out.println("--------------------");

                for(FamousSaying f:famousSayingList){
                    System.out.println(f.id + "  /  " +f.author + "  /  " +f.f_text);
                }

                System.out.print("명령)");
                cmd  = scanner.nextLine();
            }
            else if(cmd.contains("삭제")){
                Pattern pattern = Pattern.compile("(\\d+)");
                Matcher matcher = pattern.matcher(cmd);
                boolean found = false;
                if(matcher.find()){
                    String num = matcher.group();
                    int nNum = Integer.parseInt(num);
                    for(int k =0;k<famousSayingList.size();k++){
                        if(famousSayingList.get(k).id == nNum){
                            famousSayingList.remove(k);
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        System.out.println(nNum+"번 명언은 존재하지 않습니다.");
                    }else{
                        System.out.println(nNum+ "번 명언이 삭제되었습니다.");
                    }

                }
                System.out.print("명령)");
                cmd  = scanner.nextLine();
            }
            else if(cmd.contains("수정")){
                Pattern pattern = Pattern.compile("(\\d+)");
                Matcher matcher = pattern.matcher(cmd);
                boolean found = false;
                if(matcher.find()){
                    String num = matcher.group();
                    int nNum = Integer.parseInt(num);
                    for(int k =0;k<famousSayingList.size();k++){
                        if(famousSayingList.get(k).id == nNum){
                            System.out.println("명언(기존) : " + famousSayingList.get(k).f_text);
                            System.out.print("명언  :  ");
                            famousSayingList.get(k).f_text = scanner.nextLine();
                            System.out.println("작가(기존)  :  "+famousSayingList.get(k).author);
                            System.out.print("작가  :  ");
                            famousSayingList.get(k).author = scanner.nextLine();
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        System.out.println(nNum+"번 명언은 존재하지 않습니다.");
                    }else{
                        System.out.println(nNum+ "번 명언이 수정되었습니다.");
                    }

                }
                System.out.print("명령)");
                cmd  = scanner.nextLine();

            }

        }
//        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.txt"))){
//            oos.writeObject(famousSayingList);
//            System.out.println("파일 저장성공~!");
//        }catch (IOException ex){
//            System.out.println("파일 쓰기 오류 " + ex.getMessage());
//        }
        mapper = new ObjectMapper();
        try{
            mapper.writeValue(new File("data.json"),famousSayingList);
            System.out.println("파일 저장 성공");
        }catch (IOException ex){
            System.out.println("파일 쓰기 오류" + ex.getMessage());
        }

        return;



    }
}
