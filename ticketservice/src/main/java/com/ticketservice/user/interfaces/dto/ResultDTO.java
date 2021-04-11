package com.ticketservice.user.interfaces.dto;

/**
 * @Author WangZeng
 * @Date 2021-04-10 16:02
 */
public class ResultDTO<T> {
    public boolean success;
    public String msg;
    public T data;

    public ResultDTO() {
    }
    public static <T>ResultDTO<T> of(T data){
        ResultDTO<T> result = new ResultDTO<>();
        result.setData(data);
        boolean isValid = data!=null;
        result.setSuccess(isValid);
        result.setMsg(isValid?"请求成功":"返回数据为null或请求失败");
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
