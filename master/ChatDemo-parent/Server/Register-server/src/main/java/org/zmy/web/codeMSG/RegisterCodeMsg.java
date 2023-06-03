package org.zmy.web.codeMSG;


import org.zmy.codeMSG.CodeMSG;

public class RegisterCodeMsg extends CodeMSG{

    public RegisterCodeMsg(Integer code,String msg){
        super(code,msg);
    }
    public static final RegisterCodeMsg DUPLICATE_REGISTER = new RegisterCodeMsg(4001,"该账户已被注册");
}
