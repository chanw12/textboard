package org.example;

public class LoginRegistController {

    public void loginOrRegist(){
        String cmd = "";
        while((!cmd.equals("로그인") &!cmd.equals("회원가입")) & !Context.logincheck){
            System.out.print("로그인 or 회원가입 명령어를 입력해주세요: ");
            cmd = Context.scanner.nextLine();
            if(cmd.equals("로그인")){
                LoginController.lc.login();
            }else if(cmd.equals("회원가입")){
                UserController.uc.RegistUser();
            }
            cmd = "";
        }
    }
}
