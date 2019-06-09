package com.winter.controller;

import com.winter.model.Test;
import com.winter.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试控制类
 * @作者 sun
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private TestService testService;//装载测试服务

    /**
     * 保存测试数据
     * @param context 文本框信息
     */
    @ResponseBody
    @RequestMapping(value = "/os",method = RequestMethod.POST,  produces = {"application/json;charset=UTF-8"})
    public void addTest(@RequestBody String context){

        Test test = new Test();
        test.setContext(context);
        this.testService.addTest(test);//保存测试信息
    }


}
