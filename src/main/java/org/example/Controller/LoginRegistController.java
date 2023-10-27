package org.example.Controller;

import org.example.Context;

public class LoginRegistController {
    private final UserController uc;
    private final LoginController lc;
    private final Context context = Context.getInstance();
    public LoginRegistController(UserController uc,LoginController lc){
        this.uc = uc;
        this.lc = lc;
    }

    public void loginOrRegist(){
        String cmd = "";
        while((!cmd.equals("로그인") &!cmd.equals("회원가입")) & !context.getLogincheck()){
            System.out.print("로그인 or 회원가입 명령어를 입력해주세요: ");
            cmd = context.getScanner().nextLine();
            if(cmd.equals("로그인")){
                lc.login();
            }else if(cmd.equals("회원가입")){
                uc.RegistUser();
            }
            cmd = "";
        }
    }
}
