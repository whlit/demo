package cn.whlit.common;

import lombok.Getter;

/**
 * @auther WangHaiLong 2023/8/12 22:29
 */
@Getter
public class BusinessException extends RuntimeException{

    private final String code;
    private final String msg;

    public BusinessException(ResultCode code, Object... args){
        this.code = code.getCode();
        this.msg = args != null && args.length > 0 ? String.format(code.getMsg(), args) : code.getMsg();
    }
}
