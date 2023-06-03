package org.zmy.exception;

import lombok.Getter;
import org.zmy.web.codeMSG.RegisterCodeMsg;

@Getter
public class AccountDuplicateException extends RuntimeException{
    private RegisterCodeMsg registerCodeMsg;
    public AccountDuplicateException(RegisterCodeMsg registerCodeMsg){
        this.registerCodeMsg = registerCodeMsg;
    }
}
