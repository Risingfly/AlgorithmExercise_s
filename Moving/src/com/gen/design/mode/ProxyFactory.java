package com.gen.design.mode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * 思想：JDK动态代理 -->> 目标类需要实现接口，而代理类不需要，JDK实现代理只需要使用newProxyInstance方法
 *代理类所在包:java.lang.reflect.Proxy
 *      Cglib动态代理 -->> 通过创建子类继承目标类，来实现代理
 *      底层是通过使用一个小而块的字节码处理框架ASM来转换字节码并生成新的类
 *
 *      在Spring的AOP编程中:
 *                      如果加入容器的目标对象有实现接口,用JDK代理
 *                      如果目标对象没有实现接口,用Cglib代理（Spring 中包含相应的jar包）
 * @author Genge
 */
public class ProxyFactory {
    private Object target;
    public ProxyFactory(Object target){
        this.target = target;
    }
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始事务2");
//                        执行目标对象方法
                        Object res = method.invoke(target,args);
                        System.out.println("提交事务2");
                        return res;
                    }
                });
    }
}
