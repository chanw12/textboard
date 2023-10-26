package org.example;

public class UserController {
    static UserController uc = new UserController();
    public void RegistUser(){
        String id;
        boolean check;
        do{
            System.out.print("아이디 입력: ");
            id = Context.scanner.nextLine();
            check = UserService.us.checkIsAlreadyIn(id);
            if (check){
                System.out.println("이미 등록된 아이디 입니다.");
            }
        }while(check); //아이디 중복체크

        System.out.print("비밀번호를 입력하세요:  ");
        String pwd = Context.scanner.nextLine();
        UserService.us.RegisUser(id,pwd);
        System.out.println("회원가입이 성공했습니다");

    }
}
