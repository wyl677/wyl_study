package com.wyl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author:yanl.wang
 * Date:2022/3/27 22:37
 */
public class Spring5Test {
    @Test
    public void add(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.addUser();
    }
}
