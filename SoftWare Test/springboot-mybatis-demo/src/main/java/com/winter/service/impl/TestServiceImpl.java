package com.winter.service.impl;

import com.winter.beans.ResultResponse;
import com.winter.mapper.TestMapper;
import com.winter.model.Test;
import com.winter.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试服务实现
 * @作者 sun
 */
@Service(value = "testService")
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;//装载测试数据层接口服务

    /**
     * 保存测试信息服务实现方法
     * @param test 测试信息
     * @return
     */
    @Override
    public ResultResponse addTest(Test test) {
        int f = testMapper.insert(test);//调用保存接口
        return null;
    }
}
