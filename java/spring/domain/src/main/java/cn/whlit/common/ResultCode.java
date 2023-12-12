package cn.whlit.common;

import lombok.Getter;

/**
 * @auther WangHaiLong 2023/8/12 22:18
 */
@Getter
public enum ResultCode {
    SUCCESS("00000", "success"),
    ;

    private final String code;
    private final String msg;

    ResultCode(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
