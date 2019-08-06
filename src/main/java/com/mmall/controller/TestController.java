package com.mmall.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.DelayQueue;

@RestController
@Slf4j
public class TestController {

    @RequestMapping("test.do")
    public void test() {
        log.info("=====访问成功=====");
        DelayQueue q = new DelayQueue();
    }

}
