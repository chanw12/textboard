package org.example;

public class UserController {
    UserService us = new UserService();
    public void RegistUser(){
        System.out.print("아이디 입력: ");
        String id = Context.scanner.nextLine();

        while(us.checkIsAlreadyIn(id)){  //아이디 중복 여부체크
            System.out.println("이미 등록된 아이디 입니다.");
        }

        System.out.print("비밀번호를 입력하세요:  ");
        String pwd = Context.scanner.nextLine();
        us.RegisUser(id,pwd);
        System.out.println("회원가입이 성공했습니다");

    }
}
