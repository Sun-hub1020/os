package com.winter.mapper;


import com.winter.model.Test;

/**
 * 测试数据层接口
 */
public interface TestMapper {

    /**
     *  保存测试数据
     * @param test 测试数据
     * @return
     */
    int insert(Test test);
}
