package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    /**
     * 被代理的目标
     */
    private Object target;

    public Object bind(Object target){
        this.target = target;
        return Proxy
                .newProxyInstance(target.getClass().getClassLoader()
                        ,target.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 切入代码
        System.out.println("记录日志");

        Object result = method.invoke(target, args);
        return result;
    }


    /**
     * 优点
     * 1. 不需要实现指定一类对象
     * 2. 动态生成，通用代理
     *
     * 缺点
     * 1. 因为生成代码已经继承 Proxy，所以只能代理接口类
     *
     */
}
