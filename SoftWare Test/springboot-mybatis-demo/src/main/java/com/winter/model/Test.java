package com.winter.model;

/**
 * 测试信息实体类
 * @作者 sun
 */
public class Test {

	
    //自增主键
    private String name;
    //内容
    private String password;

    public String getId() {
        return name;
    }

    public String getContext() {
        return password;
    }

    public void setId(String name) {
        this.name = name;
    }

    public void setContext(String password) {
        this.password = password;
    }
}
