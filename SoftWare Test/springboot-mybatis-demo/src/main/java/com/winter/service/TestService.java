package com.winter.service;

import com.winter.beans.ResultResponse;
import com.winter.model.Test;

/**
 * 测试服务接口
 * @作者 sun
 */
public interface TestService {

    /**
     * 保存测试信息服务
     * @param test 测试信息
     * @return null
     */
    ResultResponse addTest(Test test);

}
