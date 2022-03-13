package com.wyl.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:yanl.wang
 * Date:2022/3/14 0:02
 */
@ResponseBody //返回以字符串的方式返回给浏览器(直接写给浏览器而不是跳转到某个页面)
@Controller
//@RestController (就等于@ResponseBody + @Controller)
public class HelloController {

    //    @ResponseBody //返回以字符串的方式返回给浏览器
    @RequestMapping("/hello")
    public String handle01() {
        return "Hello, SpringBoot 2!";
    }
}
