package cn.whlit.common;

import lombok.Data;

/**
 * @auther WangHaiLong 2023/8/12 22:13
 */
@Data
public class Result<T> {

    /**
     * 状态码
     */
    private String code;
    /**
     * 状态信息/错误信息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;

    public static <T> Result<T> success(T data){
        Result<T> res = new Result<>();
        res.setCode(ResultCode.SUCCESS.getCode());
        res.setMsg(ResultCode.SUCCESS.getMsg());
        res.setData(data);
        return res;
    }

    public static <T> Result<T> err(ResultCode code, Object... args){
        Result<T> res = new Result<>();
        res.setCode(code.getCode());
        if (args != null && args.length > 0){
            res.setMsg(String.format(code.getMsg(), args));
        }else {
            res.setMsg(code.getMsg());
        }
        return res;
    }

}
