package com.baizhi.dao1;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;


/**
 * @author zzu
 * @date 2018/12/8 - 12:58
 */
    //基于JDK的动态代理   代理类实现InvocationHandle接口
public class HelloServiceProxy implements InvocationHandler {
    //目标类
    private Object target;
    //将目标类绑定生成代理类
    public Object bind(Object target){
        this.target = target;
        //获得代理对象  三个参数:类加载器,接口,InvocationHandle对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = null;
        System.out.println("代理对象执行之前");
        invoke = method.invoke(target,args);
        System.out.println("代理对象执行之后");
        return invoke;
    }
}
