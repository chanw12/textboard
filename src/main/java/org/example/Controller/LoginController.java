package org.example.Controller;

import org.example.Context;
import org.example.Service.LoginService;

public class LoginController {
    private final LoginService ls;
    public LoginController(LoginService ls){
        this.ls = ls;
    }
    Context context = Context.getInstance();
    public void login(){

        String id;
        String pwd;

        do{
            System.out.print("아이디 입력: ");
            id = context.getScanner().nextLine();
            System.out.print("비밀번호 입력:  ");
            pwd = context.getScanner().nextLine();

            context.setLogincheck(ls.checkCanLogin(id,pwd));
            System.out.println(ls.checkCanLogin(id,pwd));

            if(!context.getLogincheck()){
                System.out.println("아아디 및 비밀번호가 정확하지 않습니다.");
            }else{
                System.out.println("로그인 성공!!!!");
            }
        }while(!context.getLogincheck());


    }
}
