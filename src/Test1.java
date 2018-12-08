import com.baizhi.dao1.HelloService;
import com.baizhi.dao1.HelloServiceImpl;
import com.baizhi.dao1.HelloServiceProxy;
import com.baizhi.dao1.ReflectService;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author zzu
 * @date 2018/12/7 - 21:20
 */
public class Test1 {
    @Test
    public void test1(){
        try {

           //通过反射创建对象
            Object o = Class.forName(ReflectService.class.getName()).newInstance();
            //获取接口中的方法-sayHello
            Method method = o.getClass().getMethod("sayHello", String.class);
            //调用类中的方法
            method.invoke(o,"张三");







/*
            HelloServiceProxy proxy = new HelloServiceProxy();
            HelloService bind = (HelloService) proxy.bind(new HelloServiceImpl());
            bind.sayHello("张三三");*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
