package org.zmy.web.codeMSG;


import org.zmy.codeMSG.CodeMSG;

public class RegisterCodeMsg extends CodeMSG{

    private RegisterCodeMsg(Integer code,String msg){
        super(code,msg);
    }
    public static final RegisterCodeMsg DUPLICATE_REGISTER = new RegisterCodeMsg(4001,"该账户已被注册");
    public static final RegisterCodeMsg REGISTER_FAIL = new RegisterCodeMsg(4002 ,"账号注册失败");

    public static final RegisterCodeMsg REGISTER_SUCCESS = new RegisterCodeMsg(4003,"账户注册成功");
}
