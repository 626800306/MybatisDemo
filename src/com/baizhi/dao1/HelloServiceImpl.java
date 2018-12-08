package com.baizhi.dao1;

/**
 * @author zzu
 * @date 2018/12/7 - 22:01
 */
public class HelloServiceImpl implements HelloService{

    @Override
    public void sayHello(String name) {
        System.out.println("你好!"+name);
    }
}
