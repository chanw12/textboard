package org.example;

import org.example.Service.UserService;

public class UserController {
    Context context = Context.getInstance();
    private final UserService us;
    public UserController(UserService us){
        this.us = us;
    }

    public void RegistUser(){
        String id;
        boolean check;
        do{
            System.out.print("아이디 입력: ");
            id = context.getScanner().nextLine();
            check = us.checkIsAlreadyIn(id);
            if (check){
                System.out.println("이미 등록된 아이디 입니다.");
            }
        }while(check); //아이디 중복체크

        System.out.print("비밀번호를 입력하세요:  ");
        String pwd = context.getScanner().nextLine();
        us.RegisUser(id,pwd);
        System.out.println("회원가입이 성공했습니다");

    }
}
