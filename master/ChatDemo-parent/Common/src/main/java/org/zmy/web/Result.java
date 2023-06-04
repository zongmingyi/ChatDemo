package org.zmy.web;

import lombok.Getter;
import lombok.Setter;
import org.zmy.codeMSG.CodeMSG;

import java.io.Serializable;

@Getter@Setter
public class Result<T> implements Serializable {

    private int code;
    private String msg;
    private T data;
    public static final int SUCCESS_CODE = 200;
    public static final String SUCCESS_MESSAGE = "操作成功";
    public static final int ERROR_CODE = 500;
    public static final String ERROR_MESSAGE = "系统异常";

    public Result(){}
    private Result(int code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success(){return new Result<T>(SUCCESS_CODE,SUCCESS_MESSAGE,null);}
    public static <T> Result<T> success(T data){ return new Result<T>(SUCCESS_CODE,SUCCESS_MESSAGE,data);}
    public static <T> Result<T> success(CodeMSG codeMSG){return new Result<>(codeMSG.getCode(),codeMSG.getMsg(),null);}
    public static Result error(CodeMSG codeMSG){ return new Result(codeMSG.getCode(),codeMSG.getMsg(),null);}
    public static Result defaultError(){ return new Result(ERROR_CODE,ERROR_MESSAGE,null);}

    public boolean hasError(){
        return this.code != SUCCESS_CODE;
    }
}
