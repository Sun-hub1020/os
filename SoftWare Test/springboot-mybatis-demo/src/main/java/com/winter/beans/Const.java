package com.winter.beans;

/**
 * @program: springbootMybatis
 * @author: 王新春
 * @create: 2018-11-18 19:50
 * @description:
 **/

public enum  Const {

        SUCCESS(1),//成功返回码
        ERROR(0);//失败返回码

        private Integer  code;


    Const(Integer code) {
        this.code = code;
    }

    public Integer  getCode() {
        return code;
    }
}
