package cn.linyt.thinktanklogin.exception;


import cn.linyt.thinktanklogin.response.ResultCode;

import java.text.MessageFormat;

/**
 * @ClassName CustomException
 * @Description TODO    自定义异常类型
 * @Author Mojo
 * @Date 2020/4/14 4:34
 * @Version 1.0
 **/
public class CustomException extends RuntimeException {

    //错误代码
    ResultCode resultCode;

    public CustomException(ResultCode resultCode){
        super(resultCode.message());
        this.resultCode = resultCode;
    }

    public CustomException(ResultCode resultCode, Object... args){
        super(resultCode.message());
        String message = MessageFormat.format(resultCode.message(), args);
        resultCode.setMessage(message);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode(){
        return resultCode;
    }
}
