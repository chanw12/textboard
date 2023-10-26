package org.example;

import java.io.Console;

public class LoginController {
    static LoginController lc = new LoginController();
    Console console = System.console();
    public void login(){
        String id;
        String pwd;

        do{
            System.out.print("아이디 입력: ");
            id = Context.scanner.nextLine();
            System.out.print("비밀번호 입력:  ");
            pwd = Context.scanner.nextLine();

            Context.logincheck = LoginService.ls.checkCanLogin(id,pwd);
            System.out.println(LoginService.ls.checkCanLogin(id,pwd));

            System.out.println(Context.logincheck);
            if(!Context.logincheck){
                System.out.println("아아디 및 비밀번호가 정확하지 않습니다.");
            }else{
                System.out.println("로그인 성공!!!!");
            }
        }while(!Context.logincheck);


    }
}
