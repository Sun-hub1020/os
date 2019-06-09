package com.winter.beans;


import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by geely
 */
//@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
//保证序列化json的时候,如果是null的对象,key也会消失
//@JsonInclude(JsonInclude.Include.NON_NULL)    //设置json返回时   null不返回
public class ResultResponse<T> {


    private int code;
    private String msg;
    private T data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ResultResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }

    private ResultResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }



    private ResultResponse(T data) {
        this.data = data;
    }

    private ResultResponse(String msg) {
        this.msg = msg;
    }

    private ResultResponse(int code) {
        this.code = code;
    }

    /**
     * 成功方法
     * @return
     */
    public static ResultResponse success(String msg){
        return new ResultResponse(Const.SUCCESS.getCode(),msg);
    }

    /**
     * 成功方法
     * @param data 返回信息
     * @return
     */
    public static <T> ResultResponse success(T data){
        return new ResultResponse(Const.SUCCESS.getCode(),data);
    }

    /**
     * 失败方法
     * @return
     */
    public static ResultResponse error (String msg){
        return new ResultResponse(Const.ERROR.getCode(),msg);
    }

    /**
     * 失败方法
     * @param code 判断标识
     * @param msg 错误信息
     * @return
     */
    public static ResultResponse error(Integer code,String msg){
        return new ResultResponse(code,msg);
    }

}
